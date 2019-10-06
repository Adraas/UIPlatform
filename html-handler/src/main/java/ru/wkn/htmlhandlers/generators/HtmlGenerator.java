package ru.wkn.htmlhandlers.generators;

import lombok.Getter;
import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public abstract class HtmlGenerator {

    private RepositoryFacade repositoryFacade;
    private Map<String, String[]> standardWhitelistAttributesAndProtocols;

    public HtmlGenerator(RepositoryFacade repositoryFacade) {
        this.repositoryFacade = repositoryFacade;
        standardWhitelistAttributesAndProtocols = new HashMap<>();
        initializeStandardAttributesWithHTTProtocols();
    }

    private void initializeStandardAttributesWithHTTProtocols() {
        String[] standardWhitelistAttributes = new String[]{"accesskey", "class", "contenteditable", "contextmenu",
                "dir", "hidden", "id", "lang", "spellcheck", "style", "tabindex", "title", "xml:lang"};
        for (String attribute : standardWhitelistAttributes) {
            standardWhitelistAttributesAndProtocols.put(attribute, new String[]{"http", "https"});
        }
    }

    public abstract boolean htmlTagsFromStringIsValid(String htmlTags);

    public abstract List<HtmlTag> generateRandomHtmlTagsFromRepositoryByType(int htmlTagsQuantity);
}
