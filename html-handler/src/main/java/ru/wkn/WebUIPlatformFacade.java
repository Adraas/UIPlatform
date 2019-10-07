package ru.wkn;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.wkn.htmlhandlers.generators.HtmlGenerator;
import ru.wkn.htmlhandlers.wrappers.HtmlWrapper;

/**
 * The class {@code WebUIPlatformFacade} represents the facade pattern of the application core.
 *
 * @author Orin Adraas
 */
@Getter
@Setter
public class WebUIPlatformFacade {

    /**
     * The generator for the HTML pages.
     */
    private HtmlGenerator htmlGenerator;

    /**
     * The wrapper for the HTML pages.
     */
    private HtmlWrapper htmlWrapper;

    /**
     * Initializes a newly created {@code WebUIPlatformFacade} object with the assignment value from the context for the
     * {@code services} property.
     *
     * @param htmlGeneratorName the generator for the HTML pages bean name
     * @param htmlWrapperName   the wrapper for the HTML pages bean name
     */
    public WebUIPlatformFacade(String htmlGeneratorName, String htmlWrapperName) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/META-INF/html-handler-context.xml");
        htmlGenerator = (HtmlGenerator) applicationContext.getBean(htmlGeneratorName);
        htmlWrapper = (HtmlWrapper) applicationContext.getBean(htmlWrapperName);
    }
}
