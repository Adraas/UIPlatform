package ru.wkn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.MapKeyColumn;
import java.util.Map;

/**
 * The {@code Stylesheet} class represents the CSS for the repository.
 *
 * @author Orin Adraas
 */
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class Stylesheet {

    /**
     * The selector of the represented CSS.
     */
    @Column(name = "selector", nullable = false, length = 30)
    private String selector;

    /**
     * The declaration of the represented CSS.
     */
    @MapKeyColumn(name = "style_parameter", unique = true, length = 60)
    @Column(name = "style_parameter_value", length = 60)
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
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
