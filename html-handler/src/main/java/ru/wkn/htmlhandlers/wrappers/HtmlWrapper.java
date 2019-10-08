package ru.wkn.htmlhandlers.wrappers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import ru.wkn.RepositoryFacade;
import ru.wkn.entities.HtmlTag;
import ru.wkn.htmlutil.HtmlFormType;

import java.util.List;

/**
 * The {@code HtmlWrapper} class represents an abstract wrapping methods declaration.
 *
 * @author Orin Adraas
 */
@AllArgsConstructor
@Getter
public abstract class HtmlWrapper {

    /**
     * The facade of the repository representation.
     */
    private RepositoryFacade repositoryFacade;

    /**
     * The method for the wrapping indicating HTML tags (as a {@code HtmlTag} values) into the {@code Element} object.
     *
     * @param htmlTags     the indicating HTML tags for the wrapping
     * @param htmlFormType the given HTML form type for the wrapping
     * @return the resulting {@code Element} object contained the given {@code HtmlTag} objects
     */
    public abstract Element wrapHtmlTagsIntoForm(List<HtmlTag> htmlTags, HtmlFormType htmlFormType);

    /**
     * The method for the wrapping indicating HTML tags (as a {@code HtmlTag} values) into the {@code Document} object
     * as a full HTML page.
     *
     * @param htmlTags the indicating HTML tags for the wrapping
     * @return the resulting {@code Document} object contained the given {@code HtmlTag} objects
     */
    public abstract Document wrapHtmlTagsIntoHtmlPage(List<HtmlTag> htmlTags);
}
