package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.SeguroDTO;
import ifgoiano.FGSeguradora.models.Seguro;
import ifgoiano.FGSeguradora.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seguro")
public class SeguroController {


    @Autowired
    public SeguroService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<SeguroDTO> findById(@PathVariable Long id) {
        SeguroDTO objDTO = new SeguroDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @PostMapping
    public ResponseEntity<SeguroDTO> create(@Valid @RequestBody SeguroDTO objDTO) {
        Seguro newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<SeguroDTO>> findAll() {
        List<SeguroDTO> listDTO = service.findAll()
                .stream().map(obj -> new SeguroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<SeguroDTO> update(@PathVariable Long id, @Valid @RequestBody SeguroDTO objDTO) {
        SeguroDTO newObj = new SeguroDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
