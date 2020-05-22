package co.com.gsdd.bdconocimiento;

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

import co.com.gsdd.bdconocimiento.constantes.ConstantesGenerales;

@SpringBootApplication
@ComponentScan({ ConstantesGenerales.PACK_REPO, ConstantesGenerales.PACK_CONTROL, ConstantesGenerales.PACK_SERV,
		ConstantesGenerales.PACK_CONF, ConstantesGenerales.PACK_COMP })
public class BdConocimientoApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(BdConocimientoApplication.class, args);
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(ConstantesGenerales.C_MENSAJES);
		messageSource.setDefaultEncoding(ConstantesGenerales.UTF_8);
		return messageSource;
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new CookieLocaleResolver();
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName(ConstantesGenerales.C_LANG);
		return lci;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	
}
