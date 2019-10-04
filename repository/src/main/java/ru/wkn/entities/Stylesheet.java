package ru.wkn.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@Getter
public class Stylesheet {

    private int id;
    private String selector;
    private Map<String, String> declaration;

    public Stylesheet(String selector, Map<String, String> declaration) {
        this.selector = selector;
        this.declaration = declaration;
    }
}
