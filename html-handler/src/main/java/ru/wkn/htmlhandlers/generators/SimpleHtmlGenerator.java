package ru.wkn.htmlhandlers.generators;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;
import ru.wkn.entities.HtmlTagType;

public class SimpleHtmlGenerator implements IHtmlGenerator {

    @Override
    public HtmlTag generateHtmlTagFromString(String htmlTag) {
        return null;
    }

    @Override
    public HtmlTag generateRandomHtmlTagFromRepositoryByType(int htmlTagsQuantity, HtmlTagType htmlTagType,
                                                             RepositoryFacade repositoryFacade) {
        return null;
    }
}
