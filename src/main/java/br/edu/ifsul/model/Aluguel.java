/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Antonio
 */
@Entity
@Table(name = "aluguel")
public class Aluguel implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_aluguel", sequenceName = "seq_aluguel_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_aluguel", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", columnDefinition = "numeric(6,2)", nullable = false)
    private Double valor;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "O inicio do contrato deve ser informado")
    @Column(name = "inicioContrato", nullable = false)
    private Calendar inicioContrato;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "O fim do contrato deve ser informado")
    @Column(name = "fimContrato", nullable = false)
    private Calendar fimContrato;

    @NotNull(message = "O dia de vencimento deve ser informado")
    @Column(name = "diaVencimento", nullable = false)
    private Integer diaVencimento;

    @ManyToOne
    @NotNull(message = "A unidade condominial deve ser informada")
    @JoinColumn(name = "unidadeCondominial", referencedColumnName = "id", nullable = false)
    private UnidadeCondominial unidadeCondominial;

    @ManyToOne
    @NotNull(message = "O locatario deve ser informado")
    @JoinColumn(name = "locatario", referencedColumnName = "id", nullable = false)
    private Locatario locatario;

    @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Mensalidades> listMensalidades = new ArrayList<>();

    public void adicionarMensalidades(Mensalidades obj) {

        obj.setAluguel(this);
        this.listMensalidades.add(obj);
        
    }

    public void removerMensalidades(int intex) {

        this.listMensalidades.remove(intex);
        
    }

    public Aluguel() {
        inicioContrato = Calendar.getInstance();

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
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the inicioContrato
     */
    public Calendar getInicioContrato() {
        return inicioContrato;
    }

    /**
     * @param inicioContrato the inicioContrato to set
     */
    public void setInicioContrato(Calendar inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    /**
     * @return the fimContrato
     */
    public Calendar getFimContrato() {
        return fimContrato;
    }

    /**
     * @param fimContrato the fimContrato to set
     */
    public void setFimContrato(Calendar fimContrato) {
        this.fimContrato = fimContrato;
    }

    /**
     * @return the diaVencimento
     */
    public Integer getDiaVencimento() {
        return diaVencimento;
    }

    /**
     * @param diaVencimento the diaVencimento to set
     */
    public void setDiaVencimento(Integer diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Aluguel other = (Aluguel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the unidadeCondominial
     */
    public UnidadeCondominial getUnidadeCondominial() {
        return unidadeCondominial;
    }

    /**
     * @param unidadeCondominial the unidadeCondominial to set
     */
    public void setUnidadeCondominial(UnidadeCondominial unidadeCondominial) {
        this.unidadeCondominial = unidadeCondominial;
    }

    /**
     * @return the locatario
     */
    public Locatario getLocatario() {
        return locatario;
    }

    /**
     * @param locatario the locatario to set
     */
    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    /**
     * @return the listMensalidades
     */
    public List<Mensalidades> getListMensalidades() {
        return listMensalidades;
    }

    /**
     * @param listMensalidades the listMensalidades to set
     */
    public void setListMensalidades(List<Mensalidades> listMensalidades) {
        this.listMensalidades = listMensalidades;
    }

}
