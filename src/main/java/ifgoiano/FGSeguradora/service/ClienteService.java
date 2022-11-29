package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.ClienteDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Cliente;
import ifgoiano.FGSeguradora.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente create(@Valid ClienteDTO objDTO) {
        if (findByCPF(objDTO) != null) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        return repository.save(new Cliente(objDTO.getNome(),
                objDTO.getCpf(),
                objDTO.getDataNascimento(),
                objDTO.getGenero(),
                objDTO.getEndereco(),
                null
                ));
    }

    public Cliente findById(Long id) {
        Optional<Cliente> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado!! ID: " + id + ", Tipo: "
                + Cliente.class.getName()));
    }

    public Cliente update(Long id, ClienteDTO objDTO) {
        Cliente newObj = findById(id);
        if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        newObj.setNome(objDTO.getNome());
        newObj.setCpf(objDTO.getCpf());
        newObj.setDataNascimento(objDTO.getDataNascimento());
        newObj.setGenero(objDTO.getGenero());
        newObj.setEndereco(objDTO.getEndereco());
        return repository.save(newObj);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private Cliente findByCPF(ClienteDTO objDTO) {
        Cliente obj = repository.findByCPF(objDTO.getCpf());
        if (obj != null) {
            return obj;
        }
        return null;
    }

}
