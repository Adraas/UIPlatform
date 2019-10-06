package ru.wkn;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.wkn.htmlhandlers.generators.HtmlGenerator;
import ru.wkn.htmlhandlers.wrappers.IHtmlWrapper;

@Getter
@Setter
public class WebUIPlatformFacade {

    private HtmlGenerator htmlGenerator;
    private IHtmlWrapper htmlWrapper;

    public WebUIPlatformFacade(String htmlGeneratorName, String htmlWrapperName) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/META-INF/html-handler-context.xml");
        htmlGenerator = (HtmlGenerator) applicationContext.getBean(htmlGeneratorName);
        htmlWrapper = (IHtmlWrapper) applicationContext.getBean(htmlWrapperName);
    }
}
