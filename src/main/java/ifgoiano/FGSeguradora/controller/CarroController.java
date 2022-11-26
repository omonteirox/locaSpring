package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.CarroDTO;
import ifgoiano.FGSeguradora.DTO.GerenteDTO;
import ifgoiano.FGSeguradora.models.Carro;
import ifgoiano.FGSeguradora.models.Gerente;
import ifgoiano.FGSeguradora.service.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/carro")
public class CarroController {
    public final CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> findById(@PathVariable Long id) {
        CarroDTO objDTO = new CarroDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }
    @PostMapping
    public ResponseEntity<CarroDTO> create(@Valid @RequestBody CarroDTO objDTO) {
        Carro newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @GetMapping
    public ResponseEntity<List<CarroDTO>> findAll() {
        List<CarroDTO> listDTO = service.findAll()
                .stream().map(obj -> new CarroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CarroDTO> update(@PathVariable Long id, @Valid @RequestBody CarroDTO objDTO) {
        CarroDTO newObj = new CarroDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
