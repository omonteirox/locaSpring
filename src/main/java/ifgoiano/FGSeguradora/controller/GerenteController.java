package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.models.Gerente;
import ifgoiano.FGSeguradora.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity create(@RequestBody Gerente gerente) {
        Gerente newGerente = service.create(gerente);
        return ResponseEntity.ok().body(newGerente);
    }

    @GetMapping
    public ResponseEntity<List<Gerente>> findAll() {
        List<Gerente> allGerente = service.findAll();
        return ResponseEntity.ok().body(allGerente);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Gerente> update(@Valid @PathVariable Long id, @RequestBody Gerente gerente) {
        Gerente gerenteUpdate = service.update(id, gerente);
        return ResponseEntity.ok().body(gerenteUpdate);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
