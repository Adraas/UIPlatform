package ru.wkn.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
public class JavaScriptFunction {

    private int id;
    private String functionName;
    private Map<String, String> parameters;
    private String functionImplementation;

    public JavaScriptFunction(String functionName, Map<String, String> parameters, String functionImplementation) {
        this.functionName = functionName;
        this.parameters = parameters;
        this.functionImplementation = functionImplementation;
    }
}
