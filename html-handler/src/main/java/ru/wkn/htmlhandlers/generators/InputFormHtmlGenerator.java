package ru.wkn.htmlhandlers.generators;

import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import ru.wkn.RepositoryFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputFormHtmlGenerator extends HtmlGenerator {

    private Whitelist whitelist;

    public InputFormHtmlGenerator(RepositoryFacade repositoryFacade) {
        super(repositoryFacade);
        initializeWhitelist();
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

    @Override
    public boolean htmlTagsFromStringIsValid(String htmlTags) {
        return htmlTagsFromStringIsValid(htmlTags, whitelist);
    }

    @Override
    public List<Element> chooseRandomElementsFromRepository(int htmlTagsQuantity) {
        return null;
    }
}
