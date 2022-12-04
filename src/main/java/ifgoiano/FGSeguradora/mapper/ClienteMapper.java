package ifgoiano.FGSeguradora.mapper;

import ifgoiano.FGSeguradora.DTO.ClienteCreateDTO;
import ifgoiano.FGSeguradora.models.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public Cliente toClienteCreate(ClienteCreateDTO clienteDTO){
        return MODEL_MAPPER.map(clienteDTO, Cliente.class);
    }
}
