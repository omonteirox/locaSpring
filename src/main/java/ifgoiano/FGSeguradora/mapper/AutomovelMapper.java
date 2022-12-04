package ifgoiano.FGSeguradora.mapper;

import ifgoiano.FGSeguradora.DTO.AutomovelDTO;
import ifgoiano.FGSeguradora.models.Automovel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AutomovelMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();


    public Automovel toAutomovel(AutomovelDTO automovel){
        return MODEL_MAPPER.map(automovel,Automovel.class);
    }
    public AutomovelDTO toAutomovelDTO(Automovel automovel){
        return MODEL_MAPPER.map(automovel,AutomovelDTO.class);
    }

    public List<AutomovelDTO> toAutomovelDTOList(List<Automovel> automovelList) {
        return automovelList.stream().map(this::toAutomovelDTO).collect(Collectors.toList());
    }
}
