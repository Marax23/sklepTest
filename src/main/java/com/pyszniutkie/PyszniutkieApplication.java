package com.pyszniutkie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class PyszniutkieApplication {

	public static void main(String[] args) {
		SpringApplication.run(PyszniutkieApplication.class, args);
	}



//	@Bean
//	Validator validator() {
//		return new LocalValidatorFactoryBean();
//	}
//
//	@Override
//	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
//		validatingListener.addValidator("beforeCreate", validator());
//		validatingListener.addValidator("beforeSave", validator());
//	}

	// TODO: Zakomentowany kod w "@SpringBootApplication"  pokazuje inną mozliwość walidacji. Ja posłużyłęm się
	// TODO: prostą metodą "(user.equals"")" ale sposobów napisania walidacji jak i ogólnie programów jest wiele.

}

