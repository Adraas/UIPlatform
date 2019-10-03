package ru.wkn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.wkn.entities.UserInputEntry;

public interface UserInputEntryRepository extends CrudRepository<UserInputEntry, Integer> {

    UserInputEntry getUserInputEntryByInputEntry(String inputEntry);
}
