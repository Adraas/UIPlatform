package ru.wkn.htmlhandlers.generators;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.safety.Whitelist;
import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;
import ru.wkn.entities.HtmlTagType;
import ru.wkn.services.HtmlTagService;
import ru.wkn.services.ServiceBeanName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The {@code InputFormHtmlGenerator} class implements the HTML generator methods for the HTML input fields generating.
 *
 * @author Orin Adraas
 * @see HtmlGenerator
 */
public class InputFormHtmlGenerator extends HtmlGenerator {

    /**
     * @see #getWhitelist()
     */
    private Whitelist whitelist;

    /**
     * Initializes a newly created {@code InputFormHtmlGenerator} object with a simple assignment of parameters to the
     * fields and with the custom {@code Whitelist} content initialization.
     *
     * @param repositoryFacade {@link #getRepositoryFacade()}
     */
    public InputFormHtmlGenerator(RepositoryFacade repositoryFacade) {
        super(repositoryFacade);
        initializeWhitelist();
        setWhitelist(whitelist);
    }

    private void initializeWhitelist() {
        String[] tags = new String[]{"input", "select", "textarea"};

        List<String> inputTagAttributes = new ArrayList<>(Arrays.asList("accept", "align", "alt", "autocomplete",
                "autofocus", "border", "checked", "disabled", "form", "formaction", "formenctype", "formmethod",
                "formnovalidate", "formtarget", "list", "max", "maxlength", "min", "multiple", "name", "pattern",
                "placeholder", "readonly", "required", "size", "src", "step", "tabindex", "type", "value"));
        inputTagAttributes.addAll(getStandardWhitelistAttributesAndProtocols().keySet());

        List<String> selectTagAttributes = new ArrayList<>(Arrays.asList("autofocus", "disabled", "form", "multiple",
                "name", "required", "size", "tabindex"));
        selectTagAttributes.addAll(getStandardWhitelistAttributesAndProtocols().keySet());

        List<String> textareaTagAttributes = new ArrayList<>(Arrays.asList("autofocus", "cols", "disabled", "form",
                "maxlength", "name", "placeholder", "readonly", "required", "rows", "tabindex", "wrap"));
        textareaTagAttributes.addAll(getStandardWhitelistAttributesAndProtocols().keySet());

        whitelist = new Whitelist()
                .addTags(tags)
                .addAttributes(tags[0], inputTagAttributes.toArray(new String[0]))
                .addAttributes(tags[1], selectTagAttributes.toArray(new String[0]))
                .addAttributes(tags[2], textareaTagAttributes.toArray(new String[0]));

        for (String attribute : inputTagAttributes) {
            whitelist.addProtocols(tags[0], attribute,
                    getStandardWhitelistAttributesAndProtocols().get(attribute));
        }
        for (String attribute : selectTagAttributes) {
            whitelist.addProtocols(tags[1], attribute,
                    getStandardWhitelistAttributesAndProtocols().get(attribute));
        }
        for (String attribute : textareaTagAttributes) {
            whitelist.addProtocols(tags[2], attribute,
                    getStandardWhitelistAttributesAndProtocols().get(attribute));
        }
    }

    /**
     * @see HtmlGenerator#chooseRandomElementsFromRepositoryByType(int, HtmlTagType)
     */
    @Override
    public List<Element> chooseRandomElementsFromRepositoryByType(int htmlTagsQuantity, HtmlTagType htmlTagType) {
        List<HtmlTag> htmlTags = (List<HtmlTag>) ((HtmlTagService) getRepositoryFacade().getServiceMap()
                .get(ServiceBeanName.HTML_TAG_SERVICE)).getRepository().findHtmlTagsByType(htmlTagType);
        int[] randomValues = generateRandomValues(htmlTagsQuantity, htmlTags.size() - 1);
        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < htmlTagsQuantity; i++) {
            HtmlTag htmlTag = htmlTags.get(randomValues[i]);
            Attributes attributes = new Attributes();
            for (String attribute : htmlTag.getHtmlAttributes().keySet()) {
                attributes.put(attribute, htmlTag.getHtmlAttributes().get(attribute));
            }
            elements.add(new Element(Tag.valueOf(htmlTag.getType().getType()), "", attributes));
        }
        return elements;
    }
}
