package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.models.Pessoa;
import ifgoiano.FGSeguradora.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(){
        List<Pessoa> allPessoas = service.findAll();
        return ResponseEntity.ok().body(allPessoas);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pessoa> create(@RequestBody @Valid Pessoa pessoa){
        Pessoa createPessoa = service.create(pessoa);
        return ResponseEntity.ok().body(createPessoa);
    }
}
