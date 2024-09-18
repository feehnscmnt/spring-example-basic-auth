package br.com.basicauth.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import java.io.Serializable;

/**
 * Classe test responsável pelo teste unitário de autenticação da classe {@link BasicAuthController}.
 * 
 * @author Felipe Nascimento
 *
 */

@ExtendWith(MockitoExtension.class)
class BasicAuthControllerTest implements Serializable {
	private static final long serialVersionUID = -3589982326952847629L;
	
	@InjectMocks
    private BasicAuthController basicAuthController;
	
	@Test
    void testBasicAuthWithValidCredentials() {
        ResponseEntity<Object> response = basicAuthController.basicAuth("basicAuth", "basicAuth");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testBasicAuthWithInvalidCredentials() {
        ResponseEntity<Object> response = basicAuthController.basicAuth("invalidUser", "invalidPass");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void testBasicAuthWithEmptyCredentials() {
        ResponseEntity<Object> response = basicAuthController.basicAuth("", "");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }
    
}