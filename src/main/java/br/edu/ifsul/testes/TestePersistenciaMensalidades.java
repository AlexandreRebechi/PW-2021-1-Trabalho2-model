/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.model.Aluguel;
import br.edu.ifsul.model.Mensalidades;
import br.edu.ifsul.model.Pessoa;
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
public class TestePersistenciaMensalidades implements Serializable{
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-2021-1-Trabalho2-modelPU");
        EntityManager em = emf.createEntityManager();
        Mensalidades m = new Mensalidades();
        
        m.setValor(600.12);
        m.setDataPagamento(new GregorianCalendar(2021, Calendar.AUGUST, 6));
        m.setValorPagamento(300.6);
        m.setVencimento(new GregorianCalendar(2021, Calendar.OCTOBER, 9));
        m.setAluguel(em.find(Aluguel.class, 7));
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
