package br.com.basicauth.util;

import java.io.Serializable;

/**
 * Classe responsável pelos atributos constantes da aplicação.
 * 
 * @author Felipe Nascimento
 *
 */

public class Constants implements Serializable {
	
	public static final String STATUS_MESSAGE_UNAUTHORIZED_AUTH = "As credenciais de autenticação da aplicação não foram informadas ou estão incorretas!";
	
	public static final String STATUS_MESSAGE_CONFLICT_AUTH = "Usuário e senha não informados ou estão incorretos!";
	
	public static final String STATUS_MESSAGE_OK_AUTH = "Usuário autenticado com sucesso!";
	
	private static final long serialVersionUID = 4075301430847662849L;
	
}