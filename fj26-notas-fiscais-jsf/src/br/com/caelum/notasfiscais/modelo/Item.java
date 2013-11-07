package br.com.caelum.notasfiscais.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private Produto produto;
	private Integer quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal total;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public BigDecimal getTotal() {
		total = valorUnitario.multiply(new BigDecimal(quantidade.intValue()));
		return total;
	}

}
