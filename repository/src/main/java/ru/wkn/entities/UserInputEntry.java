package ru.wkn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class UserInputEntry {

    private int id;
    private UserInputEntryDelimiter userInputEntryDelimiter;
    private String inputEntry;

    public UserInputEntry(UserInputEntryDelimiter userInputEntryDelimiter, String inputEntry) {
        this.userInputEntryDelimiter = userInputEntryDelimiter;
        this.inputEntry = inputEntry;
    }
}
