package br.com.basicauth.component;

import org.springframework.security.core.AuthenticationException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.http.HttpStatus;
import javax.servlet.ServletException;
import org.junit.jupiter.api.Test;
import java.io.Serializable;
import org.mockito.Mockito;
import java.io.IOException;

/**
 * Classe test responsável pelo teste unitário da criação da resposta de erro personalizada na classe {@link CustomAuthEntryPoint}.
 * 
 * @author Felipe Nascimento
 *
 */

class CustomAuthEntryPointTest implements Serializable {
	private static final long serialVersionUID = 4250846027695700649L;
	
	@Test
    void testCommence() throws IOException, AuthenticationException, ServletException {
		MockHttpServletRequest req = new MockHttpServletRequest();
        MockHttpServletResponse resp = new MockHttpServletResponse();
        AuthenticationException authException = Mockito.mock(AuthenticationException.class);
        
        CustomAuthEntryPoint customAuthEntryPoint = new CustomAuthEntryPoint();
        
        customAuthEntryPoint.commence(req, resp, authException);
        
        assertEquals("application/json;charset=UTF-8", resp.getContentType());
        assertEquals(HttpStatus.UNAUTHORIZED.value(), resp.getStatus());
	}
	
}