package ru.wkn.htmlhandlers.generators;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;
import ru.wkn.entities.HtmlTagType;

import java.util.List;

public interface IHtmlGenerator {

    List<HtmlTag> generateHtmlTagsFromString(String htmlTag);

    List<HtmlTag> generateRandomHtmlTagsFromRepositoryByType(int htmlTagsQuantity, HtmlTagType htmlTagType,
                                                             RepositoryFacade repositoryFacade);
}
