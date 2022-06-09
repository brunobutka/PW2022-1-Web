/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Cidade;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author 20201PF.CC0033
 */
@Stateful
public class CidadeDAO<TIPO> extends DAOGenerico<Cidade> implements Serializable {
    
    public CidadeDAO(){
        super();
        classePersistente = Cidade.class;
        //Lista de ordenações possíveis
        listaOrdem.add(new Ordem("id", "ID", "="));
        listaOrdem.add(new Ordem("nome", "Nome", "like"));
        //Criando uma ordem para filtrar as cidades do estado
        listaOrdem.add(new Ordem("estado.nome", "Estado", "like"));
        //Ordem atual
        ordemAtual = listaOrdem.get(1);
        //Inicializar o conversor de ordem coma  lsita de ordens
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
    
}
