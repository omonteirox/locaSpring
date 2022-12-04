package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.VendedorCreateDTO;
import ifgoiano.FGSeguradora.DTO.VendedorDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Vendedor;
import ifgoiano.FGSeguradora.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository repository;

    public List<Vendedor> findAll() {
        return repository.findAll();
    }

    public Vendedor findById(Long id) {
        Optional<Vendedor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Vendedor não encontrado!! ID: " +
                id + ", Tipo: " + Vendedor.class.getName()));
    }

    public Vendedor create(@Valid VendedorCreateDTO objDTO) {
        VendedorDTO newObjDTO = new VendedorDTO(objDTO);
        if (findByCPF(newObjDTO) != null) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        return repository.save(new Vendedor(null,
                objDTO.getNome(),
                objDTO.getCpf(),
                objDTO.getDataNascimento(),
                objDTO.getLogin(),
                objDTO.getSenha(),
                objDTO.getGenero(),
                objDTO.getEndereco(),
                objDTO.getSalario()
        ));
    }

    public Vendedor update(Long id, VendedorCreateDTO objDTO) {
        Vendedor vendedorUpdate = findById(id);
        VendedorDTO newObjDTO = new VendedorDTO(objDTO);
        if (findByCPF(newObjDTO) != null && findByCPF(newObjDTO).getId() != id) {
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        vendedorUpdate.setNome(objDTO.getNome());
        vendedorUpdate.setCpf(objDTO.getCpf());
        vendedorUpdate.setDataNascimento(objDTO.getDataNascimento());
        vendedorUpdate.setLogin(objDTO.getLogin());
        vendedorUpdate.setSenha(objDTO.getSenha());
        vendedorUpdate.setGenero(objDTO.getGenero());
        vendedorUpdate.setEndereco(objDTO.getEndereco());
        vendedorUpdate.setSalario(objDTO.getSalario());
        return repository.save(vendedorUpdate);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }


    private Vendedor findByCPF(VendedorDTO objDTO) {
        Vendedor obj = repository.findByCPF(objDTO.getCpf());
        if (obj != null) {
            return obj;
        }
        return null;
    }
}
