package ifgoiano.FGSeguradora.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ifgoiano.FGSeguradora.DTO.ServicoDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_terceirizado")

@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Terceirizado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String razaoSocial;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false, unique = true)
    private String cnpj;

    @ManyToMany(targetEntity = Servico.class, cascade = CascadeType.ALL)
    private List<Servico> servicos;

    public Terceirizado(Long id, String razaoSocial, String telefone, String cnpj) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
        this.cnpj = cnpj;
    }


}

