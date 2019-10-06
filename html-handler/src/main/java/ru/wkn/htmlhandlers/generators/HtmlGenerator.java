package ru.wkn.htmlhandlers.generators;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;
import ru.wkn.entities.HtmlTagType;

import java.util.List;

public abstract class HtmlGenerator {

    public List<HtmlTag> generateHtmlTagsFromString(String htmlTags) {
        return null;
    }

    public abstract List<HtmlTag> generateRandomHtmlTagsFromRepositoryByType(int htmlTagsQuantity, HtmlTagType htmlTagType,
                                                             RepositoryFacade repositoryFacade);
}
