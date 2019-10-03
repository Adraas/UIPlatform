package ru.wkn.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The {@code UserInputEntryDelimiter} enum represents the delimiter of the data entered by the user.
 *
 * @author Orin Adraas
 */
@AllArgsConstructor
@Getter
public enum UserInputEntryDelimiter {

    /**
     * The default-delimiter (whitespace).
     */
    DEFAULT(" ");

    /**
     * The {@code String} delimiter representation.
     */
    private String delimiter;
}
