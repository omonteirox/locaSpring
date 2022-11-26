package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.CaminhoneteDTO;
import ifgoiano.FGSeguradora.models.Caminhonete;
import ifgoiano.FGSeguradora.service.CaminhoneteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/caminhonete")
public class CaminhoneteController {
    public final CaminhoneteService service;

    public CaminhoneteController(CaminhoneteService service) {
        this.service = service;
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CaminhoneteDTO> findById(@PathVariable Long id) {
        CaminhoneteDTO objDTO = new CaminhoneteDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }
    @PostMapping
    public ResponseEntity<CaminhoneteDTO> create(@Valid @RequestBody CaminhoneteDTO objDTO) {
        Caminhonete newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @GetMapping
    public ResponseEntity<List<CaminhoneteDTO>> findAll() {
        List<CaminhoneteDTO> listDTO = service.findAll()
                .stream().map(obj -> new CaminhoneteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CaminhoneteDTO> update(@PathVariable Long id, @Valid @RequestBody CaminhoneteDTO objDTO) {
        CaminhoneteDTO newObj = new CaminhoneteDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}