package ru.wkn.services;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.wkn.entities.JavaScriptFunction;
import ru.wkn.repository.JavaScriptFunctionRepository;

@Service(value = "javaScriptFunctionService")
@Getter
public class JavaScriptFunctionService implements IService<JavaScriptFunction, Integer> {

    private JavaScriptFunctionRepository repository;
}
