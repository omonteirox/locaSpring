package ifgoiano.FGSeguradora.models;

import ifgoiano.FGSeguradora.enums.AutomovelTipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Automovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AutomovelTipo tipoAutomovel;

    private String cor;

    private Double valorFipe;

    private Integer ano;

    private String placa;

    private String marca;

    private String chassi;

    private String modelo;

    private double cavalosPotencia;

    private boolean carroceriaDupla;

    private boolean quatroPorQuatro;

    private Integer quantidadePortas;

    private String categoria;

    private Double cilindrada;
    //Caminhão
    public Automovel(Long id, AutomovelTipo tipoAutomovel, String cor, Double valorFipe, Integer ano, String placa, String marca, String chassi, String modelo, double cavalosPotencia, boolean carroceriaDupla, boolean quatroPorQuatro, Integer quantidadePortas) {
        this.id = id;
        this.tipoAutomovel = tipoAutomovel;
        this.cor = cor;
        this.valorFipe = valorFipe;
        this.ano = ano;
        this.placa = placa;
        this.marca = marca;
        this.chassi = chassi;
        this.modelo = modelo;
        this.cavalosPotencia = cavalosPotencia;
        this.carroceriaDupla = carroceriaDupla;
        this.quatroPorQuatro = quatroPorQuatro;
        this.quantidadePortas = quantidadePortas;
    }
    //Carro
    public Automovel(Long id, AutomovelTipo tipoAutomovel, String cor, Double valorFipe, Integer ano, String placa, String marca, String chassi, String modelo, double cavalosPotencia, Integer quantidadePortas) {
        this.id = id;
        this.tipoAutomovel = tipoAutomovel;
        this.cor = cor;
        this.valorFipe = valorFipe;
        this.ano = ano;
        this.placa = placa;
        this.marca = marca;
        this.chassi = chassi;
        this.modelo = modelo;
        this.cavalosPotencia = cavalosPotencia;
        this.quantidadePortas = quantidadePortas;
    }
    // Moto
    public Automovel(Long id, AutomovelTipo tipoAutomovel, String cor, Double valorFipe, Integer ano, String placa, String marca, String chassi, String modelo, String categoria, Double cilindrada) {
        this.id = id;
        this.tipoAutomovel = tipoAutomovel;
        this.cor = cor;
        this.valorFipe = valorFipe;
        this.ano = ano;
        this.placa = placa;
        this.marca = marca;
        this.chassi = chassi;
        this.modelo = modelo;
        this.categoria = categoria;
        this.cilindrada = cilindrada;
    }



}