package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.MotoDTO;
import ifgoiano.FGSeguradora.models.Moto;
import ifgoiano.FGSeguradora.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/moto")
public class MotoController {
    public final MotoService service;

    public MotoController(MotoService service) {
        this.service = service;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<MotoDTO> findById(@PathVariable Long id) {
        MotoDTO objDTO = new MotoDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @PostMapping
    public ResponseEntity<MotoDTO> create(@Valid @RequestBody MotoDTO objDTO) {
        Moto newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<MotoDTO>> findAll() {
        List<MotoDTO> listDTO = service.findAll()
                .stream().map(obj -> new MotoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MotoDTO> update(@PathVariable Long id, @Valid @RequestBody MotoDTO objDTO) {
        MotoDTO newObj = new MotoDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
