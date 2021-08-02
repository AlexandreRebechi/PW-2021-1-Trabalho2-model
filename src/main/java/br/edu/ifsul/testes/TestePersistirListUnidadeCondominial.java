/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.model.Condominio;
import br.edu.ifsul.model.Pessoa;
import br.edu.ifsul.model.UnidadeCondominial;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Antonio
 */
public class TestePersistirListUnidadeCondominial implements Serializable{
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-Trabalho2-modelPU");
        EntityManager em = emf.createEntityManager();
        Condominio c = em.find(Condominio.class, 7);
        
        UnidadeCondominial uc1 = em.find(UnidadeCondominial.class, 6);
        
        c.adicionarUnidadeCondominial(uc1);
       
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
