package ru.wkn.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

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
    HTML_TAG_SERVICE(HtmlTagService.class.getAnnotation(Service.class).value()),

    /**
     * The {@link UserInputEntryService} bean name.
     */
    USER_INPUT_ENTRY_SERVICE(UserInputEntryService.class.getAnnotation(Service.class).value()),

    /**
     * The {@link StylesheetService} bean name.
     */
    STYLESHEET_SERVICE(StylesheetService.class.getAnnotation(Service.class).value()),

    /**
     * The {@link JavaScriptFunctionService} bean name.
     */
    JAVASCRIPT_FUNCTION_SERVICE(JavaScriptFunctionService.class.getAnnotation(Service.class).value());

    /**
     * The {@code String} representation of the bean name.
     */
    private String name;
}
