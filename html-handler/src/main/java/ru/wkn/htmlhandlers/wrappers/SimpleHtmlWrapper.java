package ru.wkn.htmlhandlers.wrappers;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import ru.wkn.entities.HtmlTag;
import ru.wkn.htmlforms.HtmlFormType;

import java.util.List;

public class SimpleHtmlWrapper implements IHtmlWrapper {

    @Override
    public Element wrapHtmlTagsIntoForm(List<HtmlTag> htmlTags, HtmlFormType htmlFormType) {
        Element element = new Element(htmlFormType.getHtmlFormType());
        for (HtmlTag htmlTag : htmlTags) {
            Attributes attributes = new Attributes();
            for (String attribute : htmlTag.getHtmlAttributes().keySet()) {
                attributes.put(attribute, htmlTag.getHtmlAttributes().get(attribute));
            }
            element.appendChild(new Element(Tag.valueOf(htmlTag.getType().getType()), "", attributes));
        }
        return element;
    }

    @Override
    public Document wrapHtmlTagsIntoHtmlPage(List<HtmlTag> htmlTags) {
        return null;
    }
}
