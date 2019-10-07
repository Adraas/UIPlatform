package ru.wkn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.wkn.entities.JavaScriptFunction;

public interface JavaScriptFunctionRepository extends CrudRepository<JavaScriptFunction, Integer> {
}
