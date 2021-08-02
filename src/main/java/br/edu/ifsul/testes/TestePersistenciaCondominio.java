/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.model.Condominio;
import br.edu.ifsul.model.Pessoa;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Antonio
 */
public class TestePersistenciaCondominio implements Serializable{
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-Trabalho2-modelPU");
        EntityManager em = emf.createEntityManager();
        Condominio c = new Condominio();
        
        c.setNome("predio 743");
        c.setEndereco("Cachoeiro de Itapemirim - ES");
        c.setNumero("9085");
        c.setCep("70463-220");
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
