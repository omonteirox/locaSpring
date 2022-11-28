package ifgoiano.FGSeguradora.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import ifgoiano.FGSeguradora.models.Cliente;
import ifgoiano.FGSeguradora.models.Contrato;
import ifgoiano.FGSeguradora.models.Vendedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContratoDTO implements Serializable {
    private static final long serialVersionUID = 1l;
    private Long id;

    private Float valor;

    private Long vendedorID;
    private Long clienteID;
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataValidade;



    public ContratoDTO(Contrato contrato){
        this.id = contrato.getId();
        this.valor = contrato.getValor();
        this.vendedorID = contrato.getVendedorID();
        this.clienteID = contrato.getClienteID();
        this.descricao = contrato.getDescricao();
        this.dataValidade = contrato.getDataValidade();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Long getVendedorID() {
        return vendedorID;
    }

    public void setVendedorID(Long vendedorID) {
        this.vendedorID = vendedorID;
    }

    public Long getClienteID() {
        return clienteID;
    }

    public void setClienteID(Long clienteID) {
        this.clienteID = clienteID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}
