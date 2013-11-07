package br.com.caelum.notasfiscais.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;



@ManagedBean
@ViewScoped
public class ProdutoBean {
	
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	
	public void grava(){
		
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		
		if(produto.getId() == null){
			System.out.println("Gravando Produto...");
			dao.adiciona(produto);
		}else{
			System.out.println("Atualizando Produto...");
			dao.atualiza(produto);
		}
		
		this.produtos = dao.listaTodos();
		limpaFormulario();
	}
	
	@PostConstruct
	public void carregaProdutos(){
		System.out.println("Carregando Lista de Produtos...");
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		produtos = dao.listaTodos();
	}
	
	public void remove(){
		System.out.println("Removendo Produto...");
		 
		//FacesContext.getCurrentInstance().getExternalContext().getRequestParameterValuesMap().get("id");
		
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		dao.remove(produto);
		produtos = dao.listaTodos();
		limpaFormulario();
	}
	
//	public void comecaComMaiuscula(FacesContext fc, UIComponent component,Object value) throws ValidatorException{
//		String valor = value.toString();
//		if(!valor.matches("[A-Z].*")){
//			throw new ValidatorException(new FacesMessage("Deveria começar com letra Maiúscula!"));
//		}
//	}
	
	public void limpaFormulario(){
		this.produto = new Produto();
	}
}
