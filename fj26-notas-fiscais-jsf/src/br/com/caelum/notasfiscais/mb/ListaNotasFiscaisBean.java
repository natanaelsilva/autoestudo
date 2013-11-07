package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.datamodel.NotaFiscalDataModel;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@ManagedBean
@RequestScoped
public class ListaNotasFiscaisBean {
	
	private LazyDataModel<NotaFiscal> dataModel;
	
	public ListaNotasFiscaisBean(){
		final DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		int totalRegistros = dao.quantidadeRegistros();
		
		dataModel = new NotaFiscalDataModel(totalRegistros);
	}

	public void setDataModel(LazyDataModel<NotaFiscal> dataModel) {
		this.dataModel = dataModel;
	}

	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}
}
