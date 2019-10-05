package ru.wkn.htmlhandlers.generators;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;
import ru.wkn.entities.HtmlTagType;

public interface IHtmlGenerator {

    HtmlTag generateHtmlTagFromString(String htmlTag);

    HtmlTag generateRandomHtmlTagFromRepositoryByType(int htmlTagsQuantity, HtmlTagType htmlTagType,
                                                      RepositoryFacade repositoryFacade);
}
