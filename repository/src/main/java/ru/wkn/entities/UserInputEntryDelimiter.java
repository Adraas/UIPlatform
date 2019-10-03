package ru.wkn.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserInputEntryDelimiter {

    DEFAULT(" ");

    private String delimiter;
}
