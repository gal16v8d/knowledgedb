package com.gsdd.knowledgedb;

import com.gsdd.knowledgedb.constants.GeneralConstants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication
public class KnowledgeDbApplication implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(KnowledgeDbApplication.class, args);
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
