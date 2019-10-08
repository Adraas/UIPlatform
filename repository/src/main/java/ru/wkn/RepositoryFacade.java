package ru.wkn;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.wkn.services.IService;

import java.util.Map;
import java.util.TreeMap;

/**
 * The class {@code RepositoryFacade} represents the facade pattern of the repository.
 *
 * @author Orin Adraas
 */
@Getter
@Setter
public class RepositoryFacade {

    /**
     * The collection of the {@code IService} objects. The key of map - it's a {@code IService} bean name, the value -
     * its instance.
     */
    private Map<String, IService> serviceMap;

    /**
     * Initializes a newly created {@code RepositoryFacade} object with the assignment {@code IService} values from the
     * context by means the {@code serviceBeanNames} collection.
     *
     * @param serviceBeanNames the bean names for the services
     */
    public RepositoryFacade(Iterable<String> serviceBeanNames) {
        serviceMap = new TreeMap<>();
        for (String serviceBeanName : serviceBeanNames) {
            serviceMap.put(serviceBeanName,
                    (IService) new ClassPathXmlApplicationContext("/META-INF/spring-data-context.xml")
                            .getBean(serviceBeanName));
        }
    }
}