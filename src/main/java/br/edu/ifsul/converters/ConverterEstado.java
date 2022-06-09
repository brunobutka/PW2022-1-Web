/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Estado;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author 20201PF.CC0033
 */
@Named(value = "converterEstado")
@RequestScoped
public class ConverterEstado implements Serializable, Converter{

    @PersistenceContext(unitName = "PW2022-1-WebPU")
    private EntityManager em;
    
    // da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string == null || string.equals("Selecione um registro")) {
            return null;
        } 
        
        return em.find(Estado.class, Integer.parseInt(string));
    }
    
    // converte do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if(t == null) {
            return null;
        }
        
        Estado obj = (Estado) t;
        
        return obj.getId().toString();
    }
    
}
