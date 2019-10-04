package ru.wkn.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * The {@code Stylesheet} class represents the CSS for the repository.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@Getter
public class Stylesheet {

    /**
     * The ID of the represented CSS.
     */
    private int id;

    /**
     * The selector of the represented CSS.
     */
    private String selector;

    /**
     * The declaration of the represented CSS.
     */
    private Map<String, String> declaration;

    /**
     * Initializes a newly created {@code HtmlTag} object with a simple assignment of parameters to the fields.
     *
     * @param selector    {@link #selector}
     * @param declaration {@link #declaration}
     */
    public Stylesheet(String selector, Map<String, String> declaration) {
        this.selector = selector;
        this.declaration = declaration;
    }
}
