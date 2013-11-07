package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@SessionScoped
public class UsuarioLogado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}
	
	public boolean isUsuarioLogado(){
		if(getUsuario() == null){
			return false;
		}
		return getUsuario().getLogin() != null;
	}
	
	public void guardaUsuarioLogado(Usuario usuario){
		this.usuario = usuario;
	}

	
}
