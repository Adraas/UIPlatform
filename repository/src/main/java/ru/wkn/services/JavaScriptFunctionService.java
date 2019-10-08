package ru.wkn.services;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.wkn.entities.JavaScriptFunction;
import ru.wkn.repository.JavaScriptFunctionRepository;

/**
 * The class {@code JavaScriptFunctionService} represents a repository services layer implementation.
 *
 * @author Orin Adraas
 * @see IService
 */
@Service(value = "javaScriptFunctionService")
@Getter
public class JavaScriptFunctionService implements IService<JavaScriptFunction, Integer> {

    /**
     * The {@code repository} bean represented a repository (DAO) layer.
     */
    private JavaScriptFunctionRepository repository;

    /**
     * The method for the obtaining JavaScript functions ({@code JavaScriptFunction} type) by the given function name as
     * a {@code String} value.
     *
     * @param functionName the given JS function name as a {@code String} value for the searching
     * @return a found collection of the {@code JavaScriptFunction} objects
     */
    public Iterable<JavaScriptFunction> getJavaScriptFunctionsByFunctionName(String functionName) {
        return repository.findJavaScriptFunctionByFunctionName(functionName);
    }
}
