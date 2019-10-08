package ru.wkn.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;

/**
 * The {@code HtmlTafType} enum represents a HTML tag type.
 *
 * @author Orin Adraas
 */
@AllArgsConstructor
@Getter
public enum HtmlTagType {

    /**
     * The {@code input} HTML-element representation.
     */
    INPUT("input"),

    /**
     * The {@code select} HTML-element representation.
     */
    SELECT("select"),

    /**
     * The {@code textarea} HTML-element representation.
     */
    TEXTAREA("textarea");

    /**
     * The HTML tag type as a {@code String} object.
     */
    @Column(name = "type", nullable = false, length = 20)
    private String type;
}
