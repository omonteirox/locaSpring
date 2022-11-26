package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.TerceirizadoDTO;
import ifgoiano.FGSeguradora.models.Terceirizado;
import ifgoiano.FGSeguradora.service.TerceirizadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/terceirizado")
@RestController
public class TerceirizadoController {
    @Autowired
    public TerceirizadoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TerceirizadoDTO> findById(@PathVariable Long id) {
        TerceirizadoDTO objDTO = new TerceirizadoDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @PostMapping
    public ResponseEntity<TerceirizadoDTO> create(@Valid @RequestBody TerceirizadoDTO objDTO) {
        Terceirizado newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<TerceirizadoDTO>> findAll() {
        List<TerceirizadoDTO> listDTO = service.findAll()
                .stream().map(obj -> new TerceirizadoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TerceirizadoDTO> update(@PathVariable Long id, @Valid @RequestBody TerceirizadoDTO objDTO) {
        TerceirizadoDTO newObj = new TerceirizadoDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
