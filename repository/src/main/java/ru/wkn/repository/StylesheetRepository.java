package ru.wkn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.wkn.entities.Stylesheet;

/**
 * The interface {@code StylesheetRepository} represents an abstract repository with the specific Spring Data JPA style.
 * This interface provides customized functional for a work with a datasource of {@code Stylesheet} type entities.
 * It's the DAO layer of the repository.
 *
 * @author Orin Adraas
 */
public interface StylesheetRepository extends CrudRepository<Stylesheet, Integer> {

    /**
     * The method for the obtaining stylesheet ({@code Stylesheet} type) by the given selector as a {@code String} value.
     *
     * @param selector the given CSS selector as a {@code String} value for the searching
     * @return a found {@code Stylesheet} object
     */
    Stylesheet findStylesheetBySelector(String selector);
}
