package ifgoiano.FGSeguradora.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double valor;
    @Column(nullable = false)
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
