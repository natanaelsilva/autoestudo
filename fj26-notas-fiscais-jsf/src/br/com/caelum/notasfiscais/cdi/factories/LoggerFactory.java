package br.com.caelum.notasfiscais.cdi.factories;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;

import org.apache.log4j.Logger;

public class LoggerFactory {
	
	private InjectionPoint ip;
	
	@Inject
	public LoggerFactory(InjectionPoint ip){
		this.ip = ip;
	}
	
	@Produces
	public Logger getLogger(){
		return Logger.getLogger(ip.getMember().getDeclaringClass());
	}
}
