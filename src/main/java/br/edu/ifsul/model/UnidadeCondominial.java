/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "unidadeCondominial")
public class UnidadeCondominial implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_unidadeCondominial", sequenceName = "seq_unidadeCondominial_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_unidadeCondominial", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "O numero deve ser informado")
    @Length(max = 4, message = "O numero deve ter {max} caracteres")
    @Column(name = "numero", length = 4, nullable = false)
    private String numero;

    @NotBlank(message = "A descricao deve ser informado")
    @Column(name = "descricao", columnDefinition = "text", nullable = false)
    private String descricao;

    @NotNull(message = "A area deve ser informado")
    @Column(name = "area", columnDefinition = "numeric(6,2)", nullable = false)
    private Double area;

    @NotNull(message = "O numero de quarto deve ser informado")
    @Column(name = "numeroQuarto", nullable = false)
    private Integer numeroQuarto;

    @ManyToOne
    @NotNull(message = "O condominio deve ser informado")
    @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false)
    private Condominio condominio;

    public UnidadeCondominial() {

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the area
     */
    public Double getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Double area) {
        this.area = area;
    }

    /**
     * @return the numeroQuarto
     */
    public Integer getNumeroQuarto() {
        return numeroQuarto;
    }

    /**
     * @param numeroQuarto the numeroQuarto to set
     */
    public void setNumeroQuarto(Integer numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    /**
     * @return the condominio
     */
    public Condominio getCondominio() {
        return condominio;
    }

    /**
     * @param condominio the condominio to set
     */
    public void setCondominio(Condominio condominio) {
        this.condominio = condominio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final UnidadeCondominial other = (UnidadeCondominial) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
