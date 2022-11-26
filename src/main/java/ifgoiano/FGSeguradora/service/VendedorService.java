package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.GerenteDTO;
import ifgoiano.FGSeguradora.DTO.VendedorDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Gerente;
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

    public List<Vendedor> findAll(){
        return repository.findAll();
    }

    public Vendedor findById(Long id){
        Optional<Vendedor> obj = repository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Vendedor não encontrado!! ID: "+
        id + ", Tipo: " + Vendedor.class.getName()));
    }

    public Vendedor create(@Valid VendedorDTO objDTO){
        if(findByCPF(objDTO) !=null){
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
                objDTO.getSalario(),
                objDTO.getContratos()));
    }
    public Vendedor update(Long id, VendedorDTO objDTO) {
        Vendedor vendedorUpdate = findById(id);
        if(findByCPF(objDTO) !=null && findByCPF(objDTO).getId() != id){
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
        vendedorUpdate.setContratos(objDTO.getContratos());
        return repository.save(vendedorUpdate);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private Vendedor findByCPF(VendedorDTO objDTO){
        Vendedor obj = repository.findByCPF(objDTO.getCpf());
        if(obj!=null){
            return obj;
        }
        return null;
    }
}
