package ru.wkn.repository;

import org.springframework.data.repository.CrudRepository;
import ru.wkn.entities.HtmlTag;
import ru.wkn.entities.HtmlTagType;

public interface HtmlTagRepository extends CrudRepository<HtmlTag, Integer> {

    HtmlTag getHtmlTagByType(HtmlTagType htmlTagType);
}
