package ifgoiano.FGSeguradora.DTO;

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

    private Vendedor vendedor;

    private Long vendedorID;
    private Long clienteID;
    private Cliente cliente;

    private String descricao;

    private LocalDate dataValidade;

    public ContratoDTO(Contrato contrato){
        this.id = contrato.getId();
        this.valor = contrato.getValor();
        this.vendedorID = contrato.getVendedorID();
        this.clienteID = contrato.getClienteID();
//        this.cliente.setId(contrato.getCliente().getId());
//        this.vendedor.setId(contrato.getId());
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

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
