package ru.wkn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class HtmlTag {

    private int id;
    private Map<String, String> htmlAttributes;
    private Map<String, String> stylesheet;

    public HtmlTag(Map<String, String> htmlAttributes, Map<String, String> stylesheet) {
        this.htmlAttributes = htmlAttributes;
        this.stylesheet = stylesheet;
    }
}
