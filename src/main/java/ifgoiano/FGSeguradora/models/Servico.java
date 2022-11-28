package ifgoiano.FGSeguradora.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double valor;
    @Column(nullable = false)
    private String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataServicoPrestado;

    //@OneToOne
    private String seguro;

    public Servico(Long id, Double valor, String descricao, LocalDate dataServicoPrestado, String seguro) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.dataServicoPrestado = dataServicoPrestado;
        this.seguro = seguro;
    }
}
