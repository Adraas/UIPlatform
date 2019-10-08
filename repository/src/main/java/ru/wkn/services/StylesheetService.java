package ru.wkn.services;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.wkn.entities.Stylesheet;
import ru.wkn.repository.StylesheetRepository;

@Service(value = "stylesheetService")
@Getter
public class StylesheetService implements IService<Integer, Stylesheet> {

    private StylesheetRepository repository;
}
