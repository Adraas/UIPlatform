package ru.wkn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.wkn.entities.HtmlTag;
import ru.wkn.entities.HtmlTagType;

import java.util.Collection;

/**
 * The interface {@code HtmlTagRepository} represents an abstract repository with the specific Spring Data JPA style.
 * This interface provides customized functional for a work with a datasource of {@code HtmlTag} type entities.
 * It's the DAO layer of the repository.
 *
 * @author Orin Adraas
 */
public interface HtmlTagRepository extends CrudRepository<HtmlTag, Integer> {

    /**
     * The method for the finding HTML tags ({@code HtmlTag} type) by the given HTML tag type ({@code HtmlTagType} type).
     *
     * @param htmlTagType the given HTML tag type for the searching
     * @return a collection of found {@code HtmlTag} objects
     */
    Collection<HtmlTag> findHtmlTagsByType(HtmlTagType htmlTagType);
}
