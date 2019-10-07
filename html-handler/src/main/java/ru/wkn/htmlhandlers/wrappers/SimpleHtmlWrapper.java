package ru.wkn.htmlhandlers.wrappers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;
import ru.wkn.entities.JavaScriptFunction;
import ru.wkn.entities.Stylesheet;
import ru.wkn.htmlforms.HtmlFormType;
import ru.wkn.repository.JavaScriptFunctionRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code SimpleHtmlWrapper} class implements the HTML wrapper methods for the HTML by the simple way.
 *
 * @author Orin Adraas
 * @see HtmlWrapper
 */
public class SimpleHtmlWrapper extends HtmlWrapper {

    /**
     * Initializes a newly created {@code SimpleHtmlWrapper} object with a simple assignment of parameters to the
     * fields.
     *
     * @param repositoryFacade {@link #getRepositoryFacade()}
     */
    public SimpleHtmlWrapper(RepositoryFacade repositoryFacade) {
        super(repositoryFacade);
    }

    /**
     * @see HtmlWrapper#wrapHtmlTagsIntoForm(List, HtmlFormType)
     */
    @Override
    public Element wrapHtmlTagsIntoForm(List<HtmlTag> htmlTags, HtmlFormType htmlFormType) {
        Element element = new Element(htmlFormType.getHtmlFormType());
        for (HtmlTag htmlTag : htmlTags) {
            Attributes attributes = new Attributes();
            for (String attribute : htmlTag.getHtmlAttributes().keySet()) {
                attributes.put(attribute, htmlTag.getHtmlAttributes().get(attribute));
            }
            element.appendChild(new Element(Tag.valueOf(htmlTag.getType().getType()), "", attributes));
        }
        return element;
    }

    /**
     * @see HtmlWrapper#wrapHtmlTagsIntoHtmlPage(List)
     */
    @Override
    public Document wrapHtmlTagsIntoHtmlPage(List<HtmlTag> htmlTags) {
        Map<JavaScriptFunction, String> javaScriptFunctions = extractJSFunctions(htmlTags);
        Iterable<Stylesheet> stylesheets = extractCSS(htmlTags);
        StringBuilder htmlPageBuilder = new StringBuilder("<!DOCTYPE html>\n");
        htmlPageBuilder.append("<html lang=\"ru\">\n")
                .append("<head>\n")
                .append("<title>Simple HTML input form</title>\n")
                .append("<script language=\"JavaScript\" type=\"text/javascript\">\n")
                .append(generateScriptTagContent(javaScriptFunctions.keySet()))
                .append("\n</script>\n")
                .append("<style>\n")
                .append(generateStyleTagContent(stylesheets))
                .append("\n</style>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append(generateBodyTagContent(htmlTags))
                .append("\n</body>\n")
                .append("</html>");
        return Jsoup.parse(htmlPageBuilder.toString());
    }

    private Map<JavaScriptFunction, String> extractJSFunctions(List<HtmlTag> htmlTags) {
        Map<JavaScriptFunction, String> javaScriptFunctions = new HashMap<>();
        for (HtmlTag htmlTag : htmlTags) {
            Iterable<String> attributes = htmlTag.getHtmlAttributes().keySet();
            for (String attribute : attributes) {
                if (attribute.startsWith("on")) {
                    String functionInvocation = htmlTag.getHtmlAttributes().get(attribute);
                    String functionName = functionInvocation.split("\\(")[0];
                    int firstOpeningParenthesis = functionInvocation.indexOf("(");
                    int lastClosingParenthesis = functionInvocation.lastIndexOf(")");
                    String realParameters =
                            functionInvocation.substring(firstOpeningParenthesis + 1, lastClosingParenthesis);
                    javaScriptFunctions
                            .put(((JavaScriptFunctionRepository) getRepositoryFacade().getService().getRepository())
                                    .findJavaScriptFunctionByFunctionName(functionName), realParameters);
                }
            }
        }
        return javaScriptFunctions;
    }

    private Iterable<Stylesheet> extractCSS(List<HtmlTag> htmlTags) {
        List<Stylesheet> stylesheets = new ArrayList<>();
        for (HtmlTag htmlTag : htmlTags) {
            stylesheets.add(htmlTag.getStylesheet());
        }
        return stylesheets;
    }

    private String generateScriptTagContent(Iterable<JavaScriptFunction> javaScriptFunctions) {
        StringBuilder scriptTagBuilder = new StringBuilder();
        for (JavaScriptFunction javaScriptFunction : javaScriptFunctions) {
            scriptTagBuilder.append("function ")
                    .append(javaScriptFunction.getFunctionName())
                    .append("(").append(javaScriptFunction)
                    .append(generateParametersLine(javaScriptFunction))
                    .append(") {\n")
                    .append(javaScriptFunction.getFunctionImplementation())
                    .append("\n}\n");
        }
        return scriptTagBuilder.toString();
    }

    private StringBuilder generateParametersLine(JavaScriptFunction javaScriptFunction) {
        StringBuilder parametersLineBuilder = new StringBuilder();
        if (!javaScriptFunction.getParameters().isEmpty()) {
            for (String parameterName : javaScriptFunction.getParameters().keySet()) {
                parametersLineBuilder.append(javaScriptFunction.getParameters().get(parameterName))
                        .append(" ").append(parameterName).append(", ");
            }
            parametersLineBuilder.delete(parametersLineBuilder.length() - 2, parametersLineBuilder.length());
        }
        return parametersLineBuilder;
    }

    private String generateStyleTagContent(Iterable<Stylesheet> stylesheets) {
        StringBuilder styleTagBuilder = new StringBuilder();
        for (Stylesheet stylesheet : stylesheets) {
            styleTagBuilder.append(stylesheet.getSelector()).append(" {")
                    .append(generateStyleBody(stylesheet))
                    .append("}");
        }
        return styleTagBuilder.toString();
    }

    private StringBuilder generateStyleBody(Stylesheet stylesheet) {
        StringBuilder styleBodyBuilder = new StringBuilder();
        for (String styleRule : stylesheet.getDeclaration().keySet()) {
            styleBodyBuilder.append(styleRule).append(": ")
                    .append(stylesheet.getDeclaration().get(styleRule)).append(";\n");
        }
        return styleBodyBuilder;
    }

    private String generateBodyTagContent(List<HtmlTag> htmlTags) {
        StringBuilder bodyTagBuilder = new StringBuilder();
        for (HtmlTag htmlTag : htmlTags) {
            bodyTagBuilder.append("<").append(htmlTag.getType().getType()).append(" ")
                    .append(generateAttributesLine(htmlTag))
                    .append(">\n")
                    .append(generateBodyTagContent(htmlTag.getHtmlTags()))
                    .append("\n</")
                    .append(htmlTag.getType().getType())
                    .append(">\n");
        }
        return bodyTagBuilder.toString();
    }

    private StringBuilder generateAttributesLine(HtmlTag htmlTag) {
        StringBuilder attributesLineBuilder = new StringBuilder();
        if (!htmlTag.getHtmlAttributes().isEmpty()) {
            for (String attribute : htmlTag.getHtmlAttributes().keySet()) {
                attributesLineBuilder.append(attribute).append("=\"")
                        .append(htmlTag.getHtmlAttributes().get(attribute))
                        .append("\" ");
            }
            attributesLineBuilder.delete(attributesLineBuilder.length() - 1, attributesLineBuilder.length());
        }
        return attributesLineBuilder;
    }
}
