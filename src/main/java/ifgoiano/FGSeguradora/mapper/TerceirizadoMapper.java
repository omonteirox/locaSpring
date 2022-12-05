package ifgoiano.FGSeguradora.mapper;

import ifgoiano.FGSeguradora.DTO.TerceirizadoCreateDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoDTO;
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
    public Terceirizado toTerceirizado(TerceirizadoDTO terceirizadoDTO){
        return MODEL_MAPPER.map(terceirizadoDTO, Terceirizado.class);
    }

    public TerceirizadoDTO toTerceirizadoDTO(Terceirizado terceirizado){
        return MODEL_MAPPER.map(terceirizado, TerceirizadoDTO.class);
    }

    public List<TerceirizadoDTO> toTerceirizadoCreateDTOList(List<Terceirizado> terceirizadoDTOList){
        return terceirizadoDTOList.stream().map(this::toTerceirizadoDTO).collect(Collectors.toList());
    }
}
