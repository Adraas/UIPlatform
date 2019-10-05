package ru.wkn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;
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
     * The HTML tag type.
     */
    @Enumerated(value = EnumType.STRING)
    private HtmlTagType type;

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
    @OneToOne(targetEntity = Stylesheet.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "css_id")
    private Stylesheet stylesheet;

    /**
     * The child HTML tags of this HTML tag.
     */
    @OneToMany(targetEntity = HtmlTag.class, cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "child_html_tags")
    private List<HtmlTag> htmlTags;

    /**
     * Initializes a newly created {@code HtmlTag} object with a simple assignment of parameters to the fields.
     *
     * @param type           {@link #type}
     * @param htmlAttributes {@link #htmlAttributes}
     * @param stylesheet     {@link #stylesheet}
     * @param htmlTags       {@link #htmlTags}
     */
    public HtmlTag(HtmlTagType type, Map<String, String> htmlAttributes, Stylesheet stylesheet, List<HtmlTag> htmlTags) {
        this.type = type;
        this.htmlAttributes = htmlAttributes;
        this.stylesheet = stylesheet;
        this.htmlTags = htmlTags;
    }
}
