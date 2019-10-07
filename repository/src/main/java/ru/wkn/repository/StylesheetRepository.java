package ru.wkn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.wkn.entities.Stylesheet;

public interface StylesheetRepository extends CrudRepository<Stylesheet, Integer> {
}
