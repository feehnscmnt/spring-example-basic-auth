package br.com.basicauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import br.com.basicauth.message.ResponseMessages;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import br.com.basicauth.util.Constants;
import java.io.Serializable;

/**
 * Classe controller responsável pela autenticação.
 * 
 * @author Felipe Nascimento
 *
 */

@RestController
@RequestMapping("/v1")
public class BasicAuthController implements Serializable {
	private static final long serialVersionUID = 2873755961998877849L;
	
	/**
	 * Método responsável pela autenticação.
	 * 
	 * @param user - {@link RequestParam} / {@link String} usuário informado na URL de requisição.
	 * @param pass - {@link RequestParam} / {@link String} senha informada na URL de requisição.
	 * 
	 * @return usuário autenticado.
	 * 
	 */
	@GetMapping("/basic-auth")
	public ResponseEntity<Object> basicAuth(@RequestParam String user, @RequestParam String pass) {
		
		if (user.isEmpty() && pass.isEmpty()) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseMessages(Constants.STATUS_MESSAGE_CONFLICT_AUTH, HttpStatus.CONFLICT, HttpStatus.CONFLICT.value()));
			
		}
		
		if (!user.equals("basicAuth") || !pass.equals("basicAuth")) {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ResponseMessages(Constants.STATUS_MESSAGE_CONFLICT_AUTH, HttpStatus.CONFLICT, HttpStatus.CONFLICT.value()));
			
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessages(Constants.STATUS_MESSAGE_OK_AUTH, HttpStatus.OK, HttpStatus.OK.value()));
		
	}
	
}