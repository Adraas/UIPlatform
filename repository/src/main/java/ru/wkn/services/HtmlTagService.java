package ru.wkn.services;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.wkn.entities.HtmlTag;
import ru.wkn.repository.HtmlTagRepository;

/**
 * The class {@code HtmlTagService} represents a repository services layer implementation.
 *
 * @author Orin Adraas
 * @see IService
 */
@Service
@Getter
public class HtmlTagService implements IService<HtmlTag, Integer> {

    /**
     * The {@code repository} bean represented a repository (DAO) layer.
     */
    @Qualifier(value = "htmlTagRepository")
    private HtmlTagRepository repository;

    /**
     * The method for the creating a new {@code HtmlTag} object mapping in the datasource.
     *
     * @param htmlTag the given {@code HtmlTag} object for the mapping
     */
    public void createHtmlTag(HtmlTag htmlTag) {
        repository.save(htmlTag);
    }

    /**
     * The method for the reading {@code HtmlTag} object mapping by the given ID value.
     *
     * @param id the given ID value for the searching
     * @return a found {@code HtmlTag} object or {@code null} if the object with the specified ID does not exist
     */
    public HtmlTag readHtmlTagById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * The method for the obtaining a list of all {@code HtmlTag} objects.
     *
     * @return a collection of the found objects
     */
    public Iterable<HtmlTag> getAllHtmlTags() {
        return repository.findAll();
    }
}
