/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.model.Locatario;
import br.edu.ifsul.model.Pessoa;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Antonio
 */
public class TestePersistenciaLocatario implements Serializable{
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-Trabalho2-modelPU");
        EntityManager em = emf.createEntityManager();
        Locatario l = new Locatario();
        
        l.setRenda(7000.87);
        l.setLocalTrabalho("R. Camilo Ribeiro, 190 - São Cristovao, Passo Fundo - RS");
        l.setTelefoneTrabalho("(64) 87972-3347");
        l.setNome("Stephan");
        l.setCpf("458.070.690-05");
        l.setTelefone("(79) 67637-0496");
        l.setEmail("stephan.champlin34@hotmail.com");
        
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
