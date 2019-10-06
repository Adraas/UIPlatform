package ru.wkn.htmlhandlers.generators;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;
import ru.wkn.entities.HtmlTagType;

import java.util.List;

public class SimpleHtmlGenerator extends HtmlGenerator {

    @Override
    public List<HtmlTag> generateRandomHtmlTagsFromRepositoryByType(int htmlTagsQuantity, HtmlTagType htmlTagType,
                                                                    RepositoryFacade repositoryFacade) {
        return null;
    }
}
