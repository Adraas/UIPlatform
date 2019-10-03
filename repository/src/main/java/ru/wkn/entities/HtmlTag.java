package ru.wkn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import java.util.Map;

/**
 * The {@code HtmlTag} class represents the HTML tag for the repository.
 *
 * @author Orin Adraas
 */
@Entity(name = "html_tag")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class HtmlTag {

    /**
     * The ID of the represented HTML tag.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The HTML attributes of the HTML tag.
     */
    @MapKeyColumn(name = "attribute", unique = true, length = 30)
    @Column(name = "attribute_value", length = 30)
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private Map<String, String> htmlAttributes;

    /**
     * The stylesheet (CSS) for the HTML tag.
     */
    @MapKeyColumn(name = "style_parameter", unique = true, length = 60)
    @Column(name = "style_parameter_value", length = 60)
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
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
