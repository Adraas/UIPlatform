package ru.wkn.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.Repository;
import ru.wkn.entities.UserInputEntry;

@Getter
public class UserInputEntryService implements IService {

    @Qualifier(value = "userInputEntryRepository")
    private Repository<UserInputEntry, Integer> repository;
}
