package ifgoiano.FGSeguradora.mapper;

import ifgoiano.FGSeguradora.DTO.ClienteCreateDTO;
import ifgoiano.FGSeguradora.DTO.ServicoCreateDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoCreateDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoDTO;
import ifgoiano.FGSeguradora.models.Cliente;
import ifgoiano.FGSeguradora.models.Servico;
import ifgoiano.FGSeguradora.models.Terceirizado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TerceirizadoMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Terceirizado toTerceirizadoCreate(TerceirizadoCreateDTO terceirizadoCreateDTO){
        return MODEL_MAPPER.map(terceirizadoCreateDTO, Terceirizado.class);
    }
    public TerceirizadoDTO toTerceirizadoDTO(Terceirizado terceirizado){
        return MODEL_MAPPER.map(terceirizado, TerceirizadoDTO.class);
    }
    public List<Terceirizado> toTerceirizadoList(List<TerceirizadoCreateDTO> terceirizadoDTOList) {
        return terceirizadoDTOList.stream().map(this::toTerceirizadoCreate).collect(Collectors.toList());
    }
    public List<TerceirizadoDTO> toTerceirizadoCreateDTOList(List<Terceirizado> terceirizadoDTOList){
        return terceirizadoDTOList.stream().map(this::toTerceirizadoDTO).collect(Collectors.toList());
    }
}
