/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "condominio")
public class Condominio implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_condominio", sequenceName = "seq_condominio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_condominio", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome deve ter {max} caracteres")
    @Column(name = "nome", length = 50,nullable = false)
    private String nome;
    
    @NotBlank(message = "O endereco deve ser informado")
    @Length(max = 100, message = "O endereco deve ter {max} caracteres")
    @Column(name = "endereco", length = 100,nullable = false)
    private String endereco;
    
    @NotBlank(message = "O numero deve ser informado")
    @Length(max = 4, message = "O numero deve ter {max} caracteres")
    @Column(name = "numero", length = 4,nullable = false)
    private String numero;
     
    @NotBlank(message = "O CEP deve ser informado")
    @Length(max = 9, message = "O CEP deve ter {max} caracteres")
    @Column(name = "cep", length = 9,nullable = false)
    private String cep;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "recursos",
            joinColumns
            = @JoinColumn(name = "id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "recurso", referencedColumnName = "id", nullable = false)
    )
    private Set<Recurso> recursos = new HashSet<>();
    
     @OneToMany(mappedBy = "condominio", cascade = CascadeType.ALL,
            orphanRemoval = true,fetch = FetchType.LAZY)
    private List<UnidadeCondominial> unidadeCondominais = new ArrayList<>();
    
    public void adicionarUnidadeCondominial(UnidadeCondominial obj){
        
     obj.setCondominio(this);
     this.getUnidadeCondominais().add(obj);
        
        
    }
    
    public void removerUnidadeCondominial(int intex){
        
        this.getUnidadeCondominais().remove(intex);
        
    }
    
    
    
    public Condominio() {
        
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Condominio other = (Condominio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the recursos
     */
    public Set<Recurso> getRecursos() {
        return recursos;
    }

    /**
     * @param recursos the recursos to set
     */
    public void setRecursos(Set<Recurso> recursos) {
        this.recursos = recursos;
    }

    /**
     * @return the unidadeCondominais
     */
    public List<UnidadeCondominial> getUnidadeCondominais() {
        return unidadeCondominais;
    }

    /**
     * @param unidadeCondominais the unidadeCondominais to set
     */
    public void setUnidadeCondominais(List<UnidadeCondominial> unidadeCondominais) {
        this.unidadeCondominais = unidadeCondominais;
    }
    
    
    
    
}
