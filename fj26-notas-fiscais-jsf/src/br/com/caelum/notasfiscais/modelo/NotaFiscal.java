package br.com.caelum.notasfiscais.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

@Entity
public class NotaFiscal {

	@Id
	@GeneratedValue
	private Long id;
	
	@Pattern(regexp="(\\d{2})[.](\\d{3})[.](\\d{3})/(\\d{4})-(\\d{2})", message="CNPJ inválido!")
	private String cnpj;
	
	@Temporal(TemporalType.DATE)
	private Calendar data = Calendar.getInstance();
	@OneToMany //(cascade = CascadeType.ALL)
	@JoinColumn(name = "notafiscal_id")
	private List<Item> itens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public void adicionaItem(Item item) {
		if (itens == null) {
			itens = new ArrayList<Item>();
		}

		this.itens.add(item);
	}

}
