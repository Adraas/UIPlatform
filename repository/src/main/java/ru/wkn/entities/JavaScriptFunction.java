package ru.wkn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

/**
 * The {@code JavaScriptFunction} class represents the JS function for the repository.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class JavaScriptFunction {

    /**
     * The ID of the represented JS function.
     */
    private int id;

    /**
     * The JS function name.
     */
    private String functionName;

    /**
     * The parameters of the JS function.
     */
    private Map<String, String> parameters;

    /**
     * The function implementation as a {@code String} value.
     */
    private String functionImplementation;

    /**
     * Initializes a newly created {@code JavaScriptFunction} object with a simple assignment of parameters to the fields.
     *
     * @param functionName           {@link #functionName}
     * @param parameters             {@link #parameters}
     * @param functionImplementation {@link #functionImplementation}
     */
    public JavaScriptFunction(String functionName, Map<String, String> parameters, String functionImplementation) {
        this.functionName = functionName;
        this.parameters = parameters;
        this.functionImplementation = functionImplementation;
    }
}
