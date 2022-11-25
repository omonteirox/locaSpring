package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.GerenteDTO;
import ifgoiano.FGSeguradora.models.Gerente;
import ifgoiano.FGSeguradora.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/gerente")
public class GerenteController {

    @Autowired
    public GerenteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Gerente> findById(@RequestParam @Valid Long id) {
        Gerente findGerente = service.findById(id);
        return ResponseEntity.ok().body(findGerente);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<GerenteDTO> create(@RequestBody @Valid GerenteDTO objDTO) {
        Gerente newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Gerente>> findAll() {
        List<Gerente> allGerente = service.findAll();
        return ResponseEntity.ok().body(allGerente);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GerenteDTO> update(@Valid @PathVariable Long id, @Valid @RequestBody GerenteDTO objDTO) {
        GerenteDTO newObj = new GerenteDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
