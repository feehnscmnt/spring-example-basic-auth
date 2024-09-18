package br.com.basicauth.component;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import br.com.basicauth.message.ResponseMessages;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import br.com.basicauth.util.Constants;
import javax.servlet.ServletException;
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

	@Override
    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException authException) throws IOException, ServletException {
		resp.setContentType("application/json;charset=UTF-8");
		resp.setStatus(HttpStatus.UNAUTHORIZED.value());
		resp.getWriter().write(new Gson().toJson(new ResponseMessages(Constants.STATUS_MESSAGE_UNAUTHORIZED_AUTH, HttpStatus.UNAUTHORIZED, HttpStatus.UNAUTHORIZED.value())));
	}
	
}