package ru.wkn.htmlhandlers.generators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;

import java.util.List;

@AllArgsConstructor
@Getter
public abstract class HtmlGenerator {

    private RepositoryFacade repositoryFacade;

    public List<HtmlTag> generateHtmlTagsFromString(String htmlTags) {
        return null;
    }

    public abstract List<HtmlTag> generateRandomHtmlTagsFromRepositoryByType(int htmlTagsQuantity);
}
