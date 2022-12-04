package ifgoiano.FGSeguradora.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoDTO {

    private Long id;

    @NotNull(message = "O VALOR é obrigatório!")
    @Range(min=30,max=100000,message = "A quantidade mínima 30 reais a máxima 100.000 reais")
    private Double valor;

    @NotEmpty(message = "Campo DESCRICAO é requerido.")
    @Length(min = 3, max = 100, message = "O campo DESCRICAO deve possuir entre 3 á 100 caracteres.")
    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "A data é obrigatória!")
    private LocalDate dataServicoPrestado;


   private List<TerceirizadoUpdateDTO> terceirizados;


}
