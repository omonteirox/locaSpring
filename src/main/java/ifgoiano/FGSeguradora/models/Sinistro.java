package ifgoiano.FGSeguradora.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Sinistro {
    @Id
    private Long id;
    private Boolean perdaParcial;
    private Boolean perdaTotal;
    private String descricao;

    @OneToOne
    private Cliente cliente;
    @OneToOne
    private Contrato contrato;
    @OneToOne
    private Seguro seguro;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getPerdaParcial() {
        return perdaParcial;
    }

    public void setPerdaParcial(Boolean perdaParcial) {
        this.perdaParcial = perdaParcial;
    }

    public Boolean getPerdaTotal() {
        return perdaTotal;
    }

    public void setPerdaTotal(Boolean perdaTotal) {
        this.perdaTotal = perdaTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
}
