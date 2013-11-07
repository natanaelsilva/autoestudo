package br.com.caelum.notasfiscais.datamodel;

import java.util.List;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

public class NotaFiscalDataModel extends LazyDataModel<NotaFiscal> {
	
	private static final long serialVersionUID = 1L;
	
	public NotaFiscalDataModel(int quantidade) {
		super(quantidade);
	}

	@Override
	public List<NotaFiscal> fetchLazyData(int inicio, int quantidade) {
		final DAO<NotaFiscal> dao = new DAO<NotaFiscal>(NotaFiscal.class);
		return dao.listaTodosPaginado(inicio, quantidade);
	}
}
