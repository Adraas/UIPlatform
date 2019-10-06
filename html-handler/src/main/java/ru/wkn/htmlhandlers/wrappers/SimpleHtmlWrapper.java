package ru.wkn.htmlhandlers.wrappers;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ru.wkn.entities.HtmlTag;
import ru.wkn.htmlforms.HtmlFormType;

import java.util.List;

public class SimpleHtmlWrapper implements IHtmlWrapper {

    @Override
    public Element wrapHtmlTagsIntoForm(List<HtmlTag> htmlTags, HtmlFormType htmlFormType) {
        return null;
    }

    @Override
    public Document wrapHtmlTagsIntoHtmlPage(List<HtmlTag> htmlTags) {
        return null;
    }
}
