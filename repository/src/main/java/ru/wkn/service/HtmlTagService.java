package ru.wkn.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.wkn.entities.HtmlTag;
import ru.wkn.repository.HtmlTagRepository;

@Getter
public class HtmlTagService implements IService<HtmlTag, Integer> {

    @Qualifier(value = "htmlTagRepository")
    private HtmlTagRepository repository;
}
