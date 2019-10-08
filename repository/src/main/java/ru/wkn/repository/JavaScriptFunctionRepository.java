package ru.wkn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.wkn.entities.JavaScriptFunction;

/**
 * The interface {@code JavaScriptFunctionRepository} represents an abstract repository with the specific
 * Spring Data JPA style. This interface provides customized functional for a work with a datasource of
 * {@code JavaScriptFunctionRepository} type entities. It's the DAO layer of the repository.
 *
 * @author Orin Adraas
 */
public interface JavaScriptFunctionRepository extends CrudRepository<JavaScriptFunction, Integer> {

    /**
     * The method for the obtaining JavaScript functions ({@code JavaScriptFunction} type) by the given function's name
     * as a {@code String} value.
     *
     * @param functionName the given JS function name as a {@code String} value for the searching
     * @return a found collection of the {@code JavaScriptFunction} objects
     */
    Iterable<JavaScriptFunction> findJavaScriptFunctionsByFunctionName(String functionName);

    /**
     * The method for the obtaining JavaScript functions ({@code JavaScriptFunction} type) by the given function's
     * implementation as a {@code String} value.
     *
     * @param functionImplementation the given JS function's implementation as a {@code String} value for the searching
     * @return a found collection of the {@code JavaScriptFunction} objects
     */
    Iterable<JavaScriptFunction> findJavaScriptFunctionsByFunctionImplementation(String functionImplementation);
}
