package ru.wkn.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;

@AllArgsConstructor
@Getter
public enum HtmlTagType {

    INPUT("input"),
    SELECT("select"),
    CHECKBOX("checkbox"),
    TEXTAREA("textarea");

    @Column(name = "type", nullable = false, length = 20)
    private String type;
}
