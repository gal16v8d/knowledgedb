package com.gsdd.knowledgedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.gsdd.knowledgedb.constants.GeneralConstants;

@SpringBootApplication
@ComponentScan({GeneralConstants.REPO_PKG, GeneralConstants.CONTROLLER_PKG,
    GeneralConstants.SERV_PKG, GeneralConstants.CONF_PKG, GeneralConstants.COMP_PKG})
public class KnowledgeDBApplication implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(KnowledgeDBApplication.class, args);
  }

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasename(GeneralConstants.C_MSG);
    messageSource.setDefaultEncoding(GeneralConstants.UTF_8);
    return messageSource;
  }

  @Bean
  public LocaleResolver localeResolver() {
    return new CookieLocaleResolver();
  }

  @Bean
  public LocaleChangeInterceptor localeChangeInterceptor() {
    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
    lci.setParamName(GeneralConstants.C_LANG);
    return lci;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(localeChangeInterceptor());
  }

}
