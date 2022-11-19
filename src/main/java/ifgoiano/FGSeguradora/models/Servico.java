package ifgoiano.FGSeguradora.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Servico {
    @Id
    private Long id;
    private Double valor;
    private String descricao;
    private LocalDate dataServicoPrestado;

    @OneToOne
    private Seguro seguro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataServicoPrestado() {
        return dataServicoPrestado;
    }

    public void setDataServicoPrestado(LocalDate dataServicoPrestado) {
        this.dataServicoPrestado = dataServicoPrestado;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }
}
