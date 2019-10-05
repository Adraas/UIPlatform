package ru.wkn.htmlhandlers.wrappers;

import ru.wkn.entities.HtmlTag;
import ru.wkn.htmlforms.HtmlFormType;

import java.util.List;

public interface IHtmlWrapper {

    HtmlTag wrapHtmlTagsIntoForm(List<HtmlTag> htmlTags, HtmlFormType htmlFormType);

    String wrapHtmlTagsIntoHtmlPage(List<HtmlTag> htmlTags);
}
