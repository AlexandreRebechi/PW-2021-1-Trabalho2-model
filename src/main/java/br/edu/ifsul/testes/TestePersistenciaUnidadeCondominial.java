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
public class TestePersistenciaUnidadeCondominial implements Serializable{
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-Trabalho2-modelPU");
        EntityManager em = emf.createEntityManager();
        UnidadeCondominial uc = new UnidadeCondominial();
        
        uc.setNumero("4321");
        uc.setDescricao("predio azul");
        uc.setArea(800.77);
        uc.setNumeroQuarto(3);
        uc.setCondominio(em.find(Condominio.class, 9));
        
        em.getTransaction().begin();
        em.persist(uc);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
