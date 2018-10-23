package org.superbiz.struts;


import com.opensymphony.module.sitemesh.filter.PageFilter;
import org.apache.struts2.dispatcher.ActionContextCleanUp;
import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean dispatcherFilterstruts2()     {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("struts2");
        registration.setFilter(new FilterDispatcher());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("actionPackages", "com.lq");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean dispatcherFilter()     {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("struts-cleanup");
        registration.setFilter(new ActionContextCleanUp());
        registration.addUrlPatterns("/*");
        registration.setOrder(2);
        return registration;

    }

    @Bean
    public FilterRegistrationBean sitemeshFilter()     {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setName("sitemesh");
        registration.setFilter(new PageFilter()); // return new SomeFilter()
        registration.addUrlPatterns("/*");
        registration.setOrder(3);
        return registration;
    }

}
