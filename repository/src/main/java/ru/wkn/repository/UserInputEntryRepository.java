package ru.wkn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.wkn.entities.UserInputEntry;

/**
 * The interface {@code UserInputEntryRepository} represents an abstract repository with the specific Spring Data JPA
 * style. This interface provides customized functional for a work with a datasource of {@code UserInputEntry} type
 * entities. It's the DAO layer of the repository.
 *
 * @author Orin Adraas
 */
public interface UserInputEntryRepository extends CrudRepository<UserInputEntry, Integer> {

    /**
     * The method for the obtaining user input entries ({@code UserInputEntry} type) by the given input entry as a
     * {@code String} value.
     *
     * @param inputEntry the given input entry as a {@code String} value for the searching
     * @return a found {@code UserInputEntry} object
     */
    UserInputEntry findUserInputEntryByInputEntry(String inputEntry);
}
