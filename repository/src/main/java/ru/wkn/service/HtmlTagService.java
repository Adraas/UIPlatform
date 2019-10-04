package ru.wkn.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import ru.wkn.entities.HtmlTag;
import ru.wkn.repository.HtmlTagRepository;

@Getter
public class HtmlTagService implements IService<HtmlTag, Integer> {

    @Qualifier(value = "htmlTagRepository")
    private HtmlTagRepository repository;

    public void createHtmlTag(HtmlTag htmlTag) {
        repository.save(htmlTag);
    }

    public HtmlTag readHtmlTagById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<HtmlTag> getAllHtmlTags() {
        return repository.findAll();
    }
}
