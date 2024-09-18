package br.com.basicauth;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.SpringApplication;
import java.io.Serializable;

/**
 * Classe responsável pela inicialização da aplicação.
 * 
 * @author Felipe Nascimento
 * 
 */

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.basicauth.component", "br.com.basicauth.controller", "br.com.basicauth.security" })
public class SpringExampleBasicAuthApplication implements Serializable {
	private static final long serialVersionUID = -2835234082976727933L;

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleBasicAuthApplication.class, args);
	}

}