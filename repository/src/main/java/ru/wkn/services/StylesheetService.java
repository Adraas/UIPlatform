package ru.wkn.services;

import lombok.Getter;
import org.springframework.stereotype.Service;
import ru.wkn.entities.Stylesheet;
import ru.wkn.repository.StylesheetRepository;

/**
 * The class {@code StylesheetService} represents a repository services layer implementation.
 *
 * @author Orin Adraas
 * @see IService
 */
@Service(value = "stylesheetService")
@Getter
public class StylesheetService implements IService<Integer, Stylesheet> {

    /**
     * The {@code repository} bean represented a repository (DAO) layer.
     */
    private StylesheetRepository repository;
}
