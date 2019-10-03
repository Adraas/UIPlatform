package ru.wkn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * The {@code HtmlTag} class represents the HTML tag for the repository.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class HtmlTag {

    /**
     * The ID of the represented HTML tag.
     */
    private int id;

    /**
     * The HTML attributes of the HTML tag.
     */
    private Map<String, String> htmlAttributes;

    /**
     * The stylesheet (CSS) for the HTML tag.
     */
    private Map<String, String> stylesheet;

    /**
     * Initializes a newly created {@code HtmlTag} object with a simple assignment of parameters to the fields.
     *
     * @param htmlAttributes {@link #htmlAttributes}
     * @param stylesheet     {@link #stylesheet}
     */
    public HtmlTag(Map<String, String> htmlAttributes, Map<String, String> stylesheet) {
        this.htmlAttributes = htmlAttributes;
        this.stylesheet = stylesheet;
    }
}
