package ru.wkn.htmlhandlers.generators;

import lombok.Getter;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
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
                "dir", "hidden", "id", "lang", "spellcheck", "style", "tabindex", "title", "xml:lang", "onblur",
                "onchange", "onclick", "ondbclick", "onfocus", "onkeydown", "onkeypress", "onkeyup", "onload",
                "onmousedown", "onmousemove", "onmouseout", "onmouseover", "onmouseup", "onreset", "onselect",
                "onsubmit", "onunload"};
        for (String attribute : standardWhitelistAttributes) {
            standardWhitelistAttributesAndProtocols.put(attribute, new String[]{"http", "https"});
        }
    }

    boolean htmlTagsFromStringIsValid(String htmlTags, Whitelist whitelist) {
        return Jsoup.isValid(htmlTags, whitelist);
    }

    public abstract boolean htmlTagsFromStringIsValid(String htmlTags);

    public abstract List<HtmlTag> generateRandomHtmlTagsFromRepositoryByType(int htmlTagsQuantity);
}
