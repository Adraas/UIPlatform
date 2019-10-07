package ru.wkn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import java.util.Map;

/**
 * The {@code JavaScriptFunction} class represents the JS function for the repository.
 *
 * @author Orin Adraas
 */
@Entity(name = "js_function")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class JavaScriptFunction {

    /**
     * The ID of the represented JS function.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * The JS function name.
     */
    @Column(name = "function_name", nullable = false, length = 60)
    private String functionName;

    /**
     * The parameters of the JS function. The key of this map - it's a name of the parameter, value - its type.
     */
    @MapKeyColumn(name = "parameter_type", unique = true, length = 30)
    @Column(name = "parameter_name", nullable = false, length = 30)
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
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
