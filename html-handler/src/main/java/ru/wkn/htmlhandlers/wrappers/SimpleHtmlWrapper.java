package ru.wkn.htmlhandlers.wrappers;

import ru.wkn.entities.HtmlTag;
import ru.wkn.htmlforms.HtmlFormType;

import java.util.List;

public class SimpleHtmlWrapper implements IHtmlWrapper {

    @Override
    public HtmlTag wrapHtmlTagsIntoForm(List<HtmlTag> htmlTags, HtmlFormType htmlFormType) {
        return null;
    }

    @Override
    public String wrapHtmlTagsIntoHtmlPage(List<HtmlTag> htmlTags) {
        return null;
    }
}
