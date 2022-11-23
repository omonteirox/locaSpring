package ifgoiano.FGSeguradora.service;

import ifgoiano.FGSeguradora.models.Pessoa;
import ifgoiano.FGSeguradora.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa create(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public List<Pessoa> findAll(){
        List<Pessoa> allPessoa = repository.findAll();
        return allPessoa;
    }

}
