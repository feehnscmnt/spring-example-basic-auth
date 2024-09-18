package br.com.basicauth.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import br.com.basicauth.component.CustomAuthEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import java.io.Serializable;
import java.util.Base64;

/**
 * Classe responsável pelas configurações de segurança básica da aplicação.
 * 
 * @author Felipe Nascimento
 *
 */

@Configuration
public class SecurityConfig implements Serializable {
	private String username = new String(Base64.getDecoder().decode("c3ByaW5nLWV4YW1wbGUtYmFzaWMtYXV0aA=="));
	private String password = new String(Base64.getDecoder().decode("YmFzaWMtYXV0aA=="));
	private String role = new String(Base64.getDecoder().decode("VVNFUg=="));
	private static final long serialVersionUID = -210293766872936888L;
	private CustomAuthEntryPoint customAuthEntryPoint;
	
	public SecurityConfig(CustomAuthEntryPoint customAuthEntryPoint) {
		this.customAuthEntryPoint = customAuthEntryPoint;
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests(auth -> auth.antMatchers(HttpMethod.GET, "/v1/basic-auth").hasRole(role).anyRequest().authenticated()).httpBasic(
        	withDefaults()).csrf(csrf -> csrf.disable()).exceptionHandling(handling -> handling.authenticationEntryPoint(customAuthEntryPoint));
		return httpSecurity.build();
	}
	
	@Bean
    InMemoryUserDetailsManager userDetailsService() {
		return new InMemoryUserDetailsManager(User.withUsername(username)
			.password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(password)).roles(role).build());
    }
	
}