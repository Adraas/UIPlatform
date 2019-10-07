package ru.wkn.htmlhandlers.wrappers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;
import ru.wkn.entities.JavaScriptFunction;
import ru.wkn.htmlforms.HtmlFormType;

import java.util.List;

public class SimpleHtmlWrapper extends HtmlWrapper {

    public SimpleHtmlWrapper(RepositoryFacade repositoryFacade) {
        super(repositoryFacade);
    }

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

    @Override
    public Document wrapHtmlTagsIntoHtmlPage(List<HtmlTag> htmlTags) {
        List<JavaScriptFunction> javaScriptFunctions = extractJSFunctions(htmlTags);
        StringBuilder htmlPageBuilder = new StringBuilder("<!DOCTYPE html>\n");
        htmlPageBuilder.append("<html lang=\"ru\">\n")
                .append("<head>\n")
                .append("<title>Simple HTML input form</title>\n")
                .append("<script language=\"JavaScript\" type=\"text/javascript\">\n")
                .append(generateScriptTagContent(javaScriptFunctions))
                .append("</script>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append(generateBodyTagContent(htmlTags))
                .append("</body>\n")
                .append("</html>");
        return Jsoup.parse(htmlPageBuilder.toString());
    }

    private List<JavaScriptFunction> extractJSFunctions(List<HtmlTag> htmlTags) {
        return null;
    }

    private String generateScriptTagContent(List<JavaScriptFunction> javaScriptFunctions) {
        return null;
    }

    private String generateBodyTagContent(List<HtmlTag> htmlTags) {
        return null;
    }
}
