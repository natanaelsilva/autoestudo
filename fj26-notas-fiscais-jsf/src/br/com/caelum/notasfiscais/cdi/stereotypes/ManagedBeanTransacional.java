package br.com.caelum.notasfiscais.cdi.stereotypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Stereotype;

import br.com.caelum.notasfiscais.interceptor.Transactional;

@Stereotype
@Model
@Transactional
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ManagedBeanTransacional {

}
