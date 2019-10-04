package ru.wkn.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.wkn.entities.UserInputEntry;
import ru.wkn.repository.UserInputEntryRepository;

@Getter
public class UserInputEntryService implements IService<UserInputEntry, Integer> {

    @Qualifier(value = "userInputEntryRepository")
    private UserInputEntryRepository repository;
}
