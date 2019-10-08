package ru.wkn.services;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServiceBeanName {

    HTML_TAG_SERVICE("htmlTagService"),
    USER_INPUT_ENTRY_SERVICE("userInputEntryService"),
    STYLESHEET_SERVICE("stylesheetService"),
    JAVASCRIPT_FUNCTION_SERVICE("javaScriptFunctionService");

    private String name;
}
