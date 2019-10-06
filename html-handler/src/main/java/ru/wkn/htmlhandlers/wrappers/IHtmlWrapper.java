package ru.wkn.htmlhandlers.wrappers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ru.wkn.entities.HtmlTag;
import ru.wkn.htmlforms.HtmlFormType;

import java.util.List;

public interface IHtmlWrapper {

    Element wrapHtmlTagsIntoForm(List<HtmlTag> htmlTags, HtmlFormType htmlFormType);

    Document wrapHtmlTagsIntoHtmlPage(List<HtmlTag> htmlTags);
}
