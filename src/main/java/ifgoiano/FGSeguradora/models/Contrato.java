package ifgoiano.FGSeguradora.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float valor;

    @ManyToOne
    private Vendedor vendedor;

    @OneToOne
    private Cliente cliente;

    @Column(nullable = false)
    private String descricao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataValidade;



}
