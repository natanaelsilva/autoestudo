package br.com.caelum.notasfiscais.mb;


import javax.inject.Inject;

import org.apache.log4j.Logger;

import br.com.caelum.notasfiscais.cdi.stereotypes.ManagedBeanTransacional;
import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBeanTransacional
public class LoginBean {
	
	@Inject
	private Logger logger;
	
	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioLogado usuarioLogado;
	
	@Inject
	private UsuarioDAO dao;
	

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuaLogin(){
		logger.info("Efetuando login de usuário");
		//System.out.println("Validando Usuário...");
		
		boolean loginValido = dao.existe(this.usuario);
		if(loginValido){
			usuarioLogado.guardaUsuarioLogado(this.usuario);
			return "mainpage?faces-redirect=true";
		}else{
			return "login";
		}
	}
	
//	public boolean isUsuarioLogado(){
//		if(usuario == null){
//			return false;
//		}
//		return usuario.getLogin() != null;
//	}
}
