package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.models.Servico;
import ifgoiano.FGSeguradora.repository.ServicoRepository;
import ifgoiano.FGSeguradora.service.ServicoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Serviço",description = "Tudo sobre Serviços")
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    public ServicoService service;

    @Autowired
    public ServicoRepository repository;

    @PostMapping("/create")
    public ResponseEntity<Servico> create(@RequestBody Servico servico) {
        Servico obj = service.create(servico);
        return ResponseEntity.ok().body(obj);

    }

    @DeleteMapping("/deletar/{id}")

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/detalhes/{id}")

    public Servico findById(@PathVariable Long id) {

        if(repository.findById(id).isPresent())

        return repository.findById(id).get();

    else return null;

    }

    @GetMapping("/findAll")
    public List<Servico> findAll() {
        return repository.findAll();
    }

    @PutMapping("/atualizar/{id}")

    public Servico update(@PathVariable Long id, @RequestBody Servico role) {
        return service.update(id, role);

    }
}
