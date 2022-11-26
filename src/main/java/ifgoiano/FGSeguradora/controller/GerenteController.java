package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.GerenteDTO;
import ifgoiano.FGSeguradora.models.Gerente;
import ifgoiano.FGSeguradora.service.GerenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/gerente")
public class GerenteController {

    @Autowired
    public GerenteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<GerenteDTO> findById(@PathVariable Long id) {
        GerenteDTO objDTO = new GerenteDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @PostMapping
    public ResponseEntity<GerenteDTO> create(@Valid @RequestBody GerenteDTO objDTO) {
        Gerente newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<GerenteDTO>> findAll() {
        List<GerenteDTO> listDTO = service.findAll()
                .stream().map(obj -> new GerenteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GerenteDTO> update(@PathVariable Long id, @Valid @RequestBody GerenteDTO objDTO) {
        GerenteDTO newObj = new GerenteDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
