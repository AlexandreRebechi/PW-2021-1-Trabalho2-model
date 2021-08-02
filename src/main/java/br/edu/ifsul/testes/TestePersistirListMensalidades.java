/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.model.Aluguel;
import br.edu.ifsul.model.Locatario;
import br.edu.ifsul.model.Mensalidades;
import br.edu.ifsul.model.Pessoa;
import br.edu.ifsul.model.UnidadeCondominial;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Antonio
 */
public class TestePersistirListMensalidades implements Serializable{
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-Trabalho2-modelPU");
        EntityManager em = emf.createEntityManager();
        Aluguel a = em.find(Aluguel.class, 6);
        
        Mensalidades m = em.find(Mensalidades.class, 2);
        a.adicionarMensalidades(m);
        
       
        
        
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
