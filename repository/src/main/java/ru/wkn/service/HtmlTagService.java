package ru.wkn.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.Repository;
import ru.wkn.entities.HtmlTag;

@Getter
public class HtmlTagService implements IService<HtmlTag, Integer> {

    @Qualifier(value = "htmlTagRepository")
    private Repository<HtmlTag, Integer> repository;
}
