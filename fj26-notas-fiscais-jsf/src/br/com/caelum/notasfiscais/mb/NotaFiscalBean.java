package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
@ViewScoped
public class NotaFiscalBean {

	private Item item = new Item();
	private NotaFiscal notaFiscal = new NotaFiscal();
	private Long idProduto;
	
	public void setItem(Item item) {
		this.item = item;
	}
	public Item getItem() {
		return item;
	}
	
	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	
	public void adicionaItem(){
		DAO<Produto> dao = new DAO<Produto>(Produto.class);
		System.out.println("Buscando Produto por ID...");
		Produto produto = dao.buscaPorId(idProduto);
		
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		notaFiscal.adicionaItem(item);
		item = new Item();
	}
	
	public void adiciona(){
		DAO<NotaFiscal> notaFiscalDAO = new DAO<NotaFiscal>(NotaFiscal.class);
		DAO<Item> itemDAO = new DAO<Item>(Item.class); 
		
		for(Item item : notaFiscal.getItens()){
			System.out.println("Gravando Item...");
			itemDAO.adiciona(item);
		}
		
		System.out.println("Gravando Nota Fiscal...");
		notaFiscalDAO.adiciona(notaFiscal);
		
		limpaFormulario();
	}
	
	public void limpaFormulario(){
		this.item = new Item();
		this.notaFiscal = new NotaFiscal();
	}
}
