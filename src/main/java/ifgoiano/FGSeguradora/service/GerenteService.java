package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.DTO.GerenteDTO;
import ifgoiano.FGSeguradora.exception.DataIntegratyViolationException;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Gerente;
import ifgoiano.FGSeguradora.repository.GerenteRepository;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerenteService {

    @Autowired
    private GerenteRepository repository;

    public List<Gerente> findAll() {
        List<Gerente> allGerente = repository.findAll();
        return allGerente;
    }

    public Gerente create(GerenteDTO objDTO) {
        if(findByCPF(objDTO) != null){
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        return repository.save(new Gerente(null,
                objDTO.getNome(),
                objDTO.getCpf(),
                objDTO.getDataNascimento(),
                objDTO.getLogin(),
                objDTO.getSenha(),
                objDTO.getGenero(),
                objDTO.getEndereco()
             ));
    }
//    Long id, String nome, @CPF String cpf, LocalDate dataNascimento, String genero,
//    String endereco, Long id1, String login, String senha
//      this.id = id;
//        this.login = login;
//        this.senha = senha;
//        this.cpf = cpf;
//        this.dataNascimento = dataNascimento;
//        this.genero = genero;
//        this.endereco = endereco;
//        this.nome = nome;
    public Gerente findById(Long id) {
        Optional<Gerente> findGerente = repository.findById(id);
        return findGerente.orElseThrow(() -> new ObjectNotFoundException("Gerente não encontrado!! ID: " + id + ", Tipo: "
                + Gerente.class.getName()));
    }

    public Gerente update(Long id, GerenteDTO objDTO) {
        Gerente gerenteUpdate = findById(id);
        if(findByCPF(objDTO) !=null && findByCPF(objDTO).getId() != id){
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
        }
        gerenteUpdate.setLogin(objDTO.getLogin());
        gerenteUpdate.setSenha(objDTO.getSenha());
        gerenteUpdate.setNome(objDTO.getNome());
        gerenteUpdate.setGenero(objDTO.getGenero());
        gerenteUpdate.setDataNascimento(objDTO.getDataNascimento());
        gerenteUpdate.setEndereco(objDTO.getEndereco());
        return repository.save(gerenteUpdate);
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    private Gerente findByCPF(GerenteDTO objDTO){
        Gerente obj = repository.findByCPF(objDTO.getCpf());
        if(obj!=null){
            return obj;
        }
        return null;
    }

}
