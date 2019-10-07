package ru.wkn.htmlhandlers.wrappers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;
import ru.wkn.htmlforms.HtmlFormType;

import java.util.List;

@AllArgsConstructor
@Getter
public abstract class HtmlWrapper {

    private RepositoryFacade repositoryFacade;

    public abstract Element wrapHtmlTagsIntoForm(List<HtmlTag> htmlTags, HtmlFormType htmlFormType);

    public abstract Document wrapHtmlTagsIntoHtmlPage(List<HtmlTag> htmlTags);
}
