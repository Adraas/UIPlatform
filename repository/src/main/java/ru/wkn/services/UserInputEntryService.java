package ru.wkn.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.wkn.entities.UserInputEntry;
import ru.wkn.repository.UserInputEntryRepository;

/**
 * The class {@code UserInputEntryService} represents a repository services layer implementation.
 *
 * @author Orin Adraas
 * @see IService
 */
@Service(value = "userInputEntryService")
@Getter
public class UserInputEntryService implements IService<Integer, UserInputEntry> {

    /**
     * The {@code repository} bean represented a repository (DAO) layer.
     */
    @Qualifier(value = "userInputEntryRepository")
    private UserInputEntryRepository repository;

    /**
     * The method for the creating a new {@code UserInputEntry} object mapping in the datasource.
     *
     * @param userInputEntry the given {@code UserInputEntry} object for the mapping
     */
    public void createUserInputEntry(UserInputEntry userInputEntry) {
        repository.save(userInputEntry);
    }

    /**
     * The method for the obtaining a list of all {@code UserInputEntry} objects.
     *
     * @return a collection of the found objects
     */
    public Iterable<UserInputEntry> getAllUserInputEntries() {
        return repository.findAll();
    }
}
