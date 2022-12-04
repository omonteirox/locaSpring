package ifgoiano.FGSeguradora.mapper;

import ifgoiano.FGSeguradora.DTO.ClienteCreateDTO;
import ifgoiano.FGSeguradora.DTO.TerceirizadoCreateDTO;
import ifgoiano.FGSeguradora.models.Cliente;
import ifgoiano.FGSeguradora.models.Terceirizado;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class TerceirizadoMapper {

    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Terceirizado toTerceirizadoCreate(TerceirizadoCreateDTO terceirizadoCreateDTO){
        return MODEL_MAPPER.map(terceirizadoCreateDTO, Terceirizado.class);
    }
}
