package ru.wkn.services;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The {@code ServiceBeanName} enum sores names of the all services.
 *
 * @author Orin Adraas
 */
@AllArgsConstructor
@Getter
public enum ServiceBeanName {

    /**
     * The {@link HtmlTagService} bean name.
     */
    HTML_TAG_SERVICE("htmlTagService"),

    /**
     * The {@link UserInputEntryService} bean name.
     */
    USER_INPUT_ENTRY_SERVICE("userInputEntryService"),

    /**
     * The {@link StylesheetService} bean name.
     */
    STYLESHEET_SERVICE("stylesheetService"),

    /**
     * The {@link JavaScriptFunctionService} bean name.
     */
    JAVASCRIPT_FUNCTION_SERVICE("javaScriptFunctionService");

    /**
     * The {@code String} representation of the bean name.
     */
    private String name;
}
