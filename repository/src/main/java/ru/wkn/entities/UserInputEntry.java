package ru.wkn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The {@code UserInputEntry} class represents the data entered by the user as a single {@code String} line with
 * an indicated delimiter.
 *
 * @author Orin Adraas
 */
@Entity(name = "user_input_entry")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class UserInputEntry {

    /**
     * The ID of the represented user data.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The delimiter of the data entered by the user.
     */
    @Enumerated(value = EnumType.STRING)
    @Column(name = "delimiter", nullable = false, length = 2)
    private UserInputEntryDelimiter userInputEntryDelimiter;

    /**
     * The data entered by the user as a single {@code String} line.
     */
    @Column(name = "value")
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
