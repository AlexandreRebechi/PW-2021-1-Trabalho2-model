/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "locatario")
public class Locatario extends Pessoa implements Serializable{
    
    @NotNull(message = "Renda do locatario não informado")
    @Column(name = "renda", columnDefinition = "numeric(6,2)", nullable = false)
    private Double renda;
    
    @NotBlank(message = "O local de trabalho não informado")
    @Length(max = 100, message = "O local de trabalho deve ter {max} caracteres")
    @Column(name = "localTrabalho", length = 100, nullable = false)
    private String localTrabalho;
    
    @NotBlank(message = "O telefone do trabalho do locatario deve ser informado")
    @Length(max = 15, message = "O telefone do trabalho do locatario deve ter {max} caracteres")
    @Column(name = "telefoneTrabalho", length = 15, nullable = false)
    private String telefoneTrabalho;

    public Locatario() {
        
    }

    /**
     * @return the renda
     */
    public Double getRenda() {
        return renda;
    }

    /**
     * @param renda the renda to set
     */
    public void setRenda(Double renda) {
        this.renda = renda;
    }

    /**
     * @return the localTrabalho
     */
    public String getLocalTrabalho() {
        return localTrabalho;
    }

    /**
     * @param localTrabalho the localTrabalho to set
     */
    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    /**
     * @return the telefoneTrabalho
     */
    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    /**
     * @param telefoneTrabalho the telefoneTrabalho to set
     */
    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }
    
    
    
}
