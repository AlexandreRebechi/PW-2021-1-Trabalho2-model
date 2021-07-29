/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable{
    
    Integer id;
    
}
