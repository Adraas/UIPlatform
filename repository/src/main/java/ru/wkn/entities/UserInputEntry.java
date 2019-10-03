package ru.wkn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The {@code UserInputEntry} class represents the data entered by the user as a single {@code String} line with
 * an indicated delimiter.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class UserInputEntry {

    /**
     * The ID of the represented user data.
     */
    private int id;

    /**
     * The delimiter of the data entered by the user.
     */
    private UserInputEntryDelimiter userInputEntryDelimiter;

    /**
     * The data entered by the user as a single {@code String} line.
     */
    private String inputEntry;

    /**
     * Initializes a newly created {@code UserInputEntry} object with a simple assignment of parameters to the fields.
     *
     * @param userInputEntryDelimiter {@link #userInputEntryDelimiter}
     * @param inputEntry              {@link #inputEntry}
     */
    public UserInputEntry(UserInputEntryDelimiter userInputEntryDelimiter, String inputEntry) {
        this.userInputEntryDelimiter = userInputEntryDelimiter;
        this.inputEntry = inputEntry;
    }
}
