package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.MensagemRespostaDTO;
import ifgoiano.FGSeguradora.DTO.ServicoDTO;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.models.Servico;
import ifgoiano.FGSeguradora.repository.ServicoRepository;
import ifgoiano.FGSeguradora.service.ServicoService;
import io.swagger.annotations.Api;
import org.hibernate.ObjectDeletedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<MensagemRespostaDTO> create(@RequestBody ServicoDTO servico) throws ObjectNotFoundException {
        var obj = service.create(servico);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @DeleteMapping("/deletar/{id}")

    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/detalhes/{id}")

    public ResponseEntity<ServicoDTO> findById(@PathVariable Long id) throws ObjectDeletedException {
        if(repository.findById(id).isPresent()) {
            var obj = service.findById(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(obj);
        }
        else return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @GetMapping("/findAll")
    public List<ServicoDTO> findAll() {
        return service.findAll();
    }

    @PutMapping("/atualizar/{id}")

    public Servico update(@PathVariable Long id, @RequestBody Servico role) {
        return service.update(id, role);

    }
}
