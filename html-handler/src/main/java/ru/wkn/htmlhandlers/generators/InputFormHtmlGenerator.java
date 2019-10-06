package ru.wkn.htmlhandlers.generators;

import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import ru.wkn.RepositoryFacade;

import java.util.List;

public class InputFormHtmlGenerator extends HtmlGenerator {

    private Whitelist whitelist;

    public InputFormHtmlGenerator(RepositoryFacade repositoryFacade) {
        super(repositoryFacade);
        initializeWhitelist();
    }

    private void initializeWhitelist() {
        whitelist = new Whitelist()
                .addTags("input", "select", "checkbox", "textarea")
                .addAttributes("input", "accept", "align", "alt", "autocomplete",
                        "autofocus", "border", "checked", "disabled", "form", "formaction", "formenctype", "formmethod",
                        "formnovalidate", "formtarget", "list", "max", "maxlength", "min", "multiple", "name", "pattern",
                        "placeholder", "readonly", "required", "size", "src", "step", "tabindex", "type", "value")
                .addAttributes("select", "autofocus", "disabled", "form", "multiple", "name", "required",
                        "size", "tabindex")
                .addAttributes("textarea", "autofocus", "cols", "disabled", "form", "maxlength",
                        "name", "placeholder", "readonly", "required", "rows", "tabindex", "wrap");
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
