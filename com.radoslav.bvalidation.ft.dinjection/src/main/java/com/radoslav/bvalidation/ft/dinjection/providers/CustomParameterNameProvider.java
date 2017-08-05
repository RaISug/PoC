package com.radoslav.bvalidation.ft.dinjection.providers;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ParameterNameProvider;

import org.apache.cxf.jaxrs.model.Parameter;
import org.apache.cxf.jaxrs.utils.ResourceUtils;

public class CustomParameterNameProvider implements ParameterNameProvider {

  @Override
  public List<String> getParameterNames(Constructor<?> constructors) {
    return null;
  }

  @Override
  public List<String> getParameterNames(Method method) {
    List<String> paramNames = new ArrayList<>();

    List<Parameter> parameters = ResourceUtils.getParameters(method);
    for(Parameter parameter : parameters) {
      paramNames.add(parameter.getType() + " parameter '" + parameter.getName() + "'");
    }

    return paramNames;
  }

  
}
