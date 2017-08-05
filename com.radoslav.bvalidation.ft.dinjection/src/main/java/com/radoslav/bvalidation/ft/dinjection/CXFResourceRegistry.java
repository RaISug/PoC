package com.radoslav.bvalidation.ft.dinjection;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.apache.cxf.jaxrs.validation.JAXRSBeanValidationFeature;
import org.apache.cxf.validation.BeanValidationProvider;

import com.radoslav.bvalidation.ft.dinjection.exception.mappers.BeanValidationExceptionMapper;
import com.radoslav.bvalidation.ft.dinjection.providers.CustomParameterNameProvider;
import com.radoslav.bvalidation.ft.dinjection.providers.GsonJsonProvider;
import com.radoslav.bvalidation.ft.dinjection.rest.LogAnalyzerAPI;

public class CXFResourceRegistry extends Application {

  private Set<Object> singletons = new HashSet<Object>();
  private Set<Class<?>> classes = new HashSet<Class<?>>();

  public CXFResourceRegistry() {
    singletons.add(createValidationFeature());
    singletons.add(new GsonJsonProvider());

    singletons.add(new LogAnalyzerAPI());

    singletons.add(new BeanValidationExceptionMapper());
  }

  private JAXRSBeanValidationFeature createValidationFeature() {
    JAXRSBeanValidationFeature validationFeature = new JAXRSBeanValidationFeature();
    validationFeature.setProvider(new BeanValidationProvider(new CustomParameterNameProvider()));
    return validationFeature;
  }
  
  @Override
  public Set<Object> getSingletons() {
    return singletons;
  }
  
  @Override
  public Set<Class<?>> getClasses() {
    return classes;
  }
  
}
