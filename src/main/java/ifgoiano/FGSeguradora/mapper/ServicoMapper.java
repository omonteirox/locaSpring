package ifgoiano.FGSeguradora.mapper;

import ifgoiano.FGSeguradora.DTO.ServicoCreateDTO;
import ifgoiano.FGSeguradora.DTO.ServicoDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoCreateDTO;
import ifgoiano.FGSeguradora.models.Servico;
import ifgoiano.FGSeguradora.models.Terceirizado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServicoMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Servico toServicoCreate(ServicoDTO servicoDTOCreateDTO){
        return MODEL_MAPPER.map(servicoDTOCreateDTO, Servico.class);
    }
    public Servico toServico(ServicoCreateDTO servicoDTOCreateDTO){
        return MODEL_MAPPER.map(servicoDTOCreateDTO, Servico.class);
    }
    public List<Servico> toServicoList(List<ServicoCreateDTO> servicoDTOList) {
        return servicoDTOList.stream().map(this::toServico).collect(Collectors.toList());
    }

}
