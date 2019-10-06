package ru.wkn.htmlhandlers.generators;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;

import java.util.List;

public class InputFormHtmlGenerator extends HtmlGenerator {

    public InputFormHtmlGenerator(RepositoryFacade repositoryFacade) {
        super(repositoryFacade);
    }

    @Override
    public boolean htmlTagsFromStringIsValid(String htmlTags) {
        return false;
    }

    @Override
    public List<HtmlTag> generateRandomHtmlTagsFromRepositoryByType(int htmlTagsQuantity) {
        return null;
    }
}
