package ru.wkn.htmlhandlers.generators;

import lombok.Getter;
import lombok.Setter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTagType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The {@code HtmlGenerator} class represents the abstract algorithms declaration for the HTML pages generating.
 *
 * @author Orin Adraas
 */
@Getter
@Setter
public abstract class HtmlGenerator {

    /**
     * The facade of the repository representation.
     */
    private RepositoryFacade repositoryFacade;

    /**
     * The {@code String} values (attributes and its protocols) for the standard {@code Whitelist} content.
     */
    private Map<String, String[]> standardWhitelistAttributesAndProtocols;

    /**
     * The standard attributes and its protocols representation for the current page.
     */
    private Whitelist whitelist;

    /**
     * Initializes a newly created {@code HtmlGenerator} object with a simple assignment of parameters to the fields
     * and with the standard {@code Whitelist} content initialization.
     *
     * @param repositoryFacade {@link #repositoryFacade}
     */
    public HtmlGenerator(RepositoryFacade repositoryFacade) {
        this.repositoryFacade = repositoryFacade;
        standardWhitelistAttributesAndProtocols = new HashMap<>();
        whitelist = new Whitelist();
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

    /**
     * The method for the checking a HTML tags as a {@code String} value to validation.
     *
     * @param htmlTags the given HTML tags as a {@code String} value for the checking
     * @return {@code true} if the given HTML tags is correct, else - {@code false}
     */
    public boolean htmlTagsFromStringIsValid(String htmlTags) {
        return Jsoup.isValid(htmlTags, whitelist);
    }

    /**
     * The method for the choosing random elements from the repository by the indicating {@code HtmlTag} value.
     *
     * @param htmlTagsQuantity the number of the generating HTML tags
     * @param htmlTagType the indicating HTML tag type
     * @return the collection of the generated {@code Element} values
     */
    public abstract List<Element> chooseRandomElementsFromRepositoryByType(int htmlTagsQuantity, HtmlTagType htmlTagType);

    int[] generateRandomValues(int htmlTagsQuantity, int maximalVale) {
        Random random = new Random();
        int[] randomValues = new int[htmlTagsQuantity];
        for (int i = 0; i < htmlTagsQuantity; i++) {
            randomValues[i] = random.nextInt(maximalVale);
        }
        return randomValues;
    }
}
