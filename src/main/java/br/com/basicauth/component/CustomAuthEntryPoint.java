package br.com.basicauth.component;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import br.com.basicauth.message.ResponseMessages;
import org.springframework.stereotype.Component;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import jakarta.servlet.ServletException;
import br.com.basicauth.util.Constants;
import com.google.gson.Gson;
import java.io.Serializable;
import java.io.IOException;

/**
 * Classe component responsável por criar uma resposta de erro personalizada.
 * 
 * @author Felipe Nascimento
 *
 */

@Component
public class CustomAuthEntryPoint implements AuthenticationEntryPoint, Serializable {
	private static final long serialVersionUID = -1065299206742863407L;
	
	/**
	 * Método responsável pela inicialização de um esquema de autenticação.
	 * 
	 * @param httpServletRequest - {@link HttpServletRequest} - requisição realizada
	 * @param httpServletResponse - {@link HttpServletResponse} - resposta para que o agente do usuário inicie a autenticação
	 * @param authenticationException - {@link AuthenticationException} - causa da invocação
	 * 
	 */
	@Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authenticationException) throws IOException, ServletException {
		
		httpServletResponse.setContentType("application/json;charset=UTF-8");
		httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
		httpServletResponse.getWriter().write(new Gson().toJson(new ResponseMessages(Constants.STATUS_MESSAGE_UNAUTHORIZED_AUTH, HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value())));
		
	}
	
}