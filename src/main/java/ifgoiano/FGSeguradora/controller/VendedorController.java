package ifgoiano.FGSeguradora.controller;


import ifgoiano.FGSeguradora.DTO.GerenteDTO;
import ifgoiano.FGSeguradora.DTO.VendedorDTO;
import ifgoiano.FGSeguradora.models.Vendedor;
import ifgoiano.FGSeguradora.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService service;

    @GetMapping
    public ResponseEntity<List<VendedorDTO>> findAll(){
        List<VendedorDTO> objDTO = service.findAll().
                stream().map(obj -> new VendedorDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(objDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendedorDTO> findById(@PathVariable Long id){
        VendedorDTO objDTO = new VendedorDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @PostMapping
    public ResponseEntity<VendedorDTO> create(@Valid @RequestBody VendedorDTO objDTO){
        Vendedor newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VendedorDTO> update(@PathVariable Long id, @Valid @RequestBody VendedorDTO objDTO) {
        VendedorDTO newObj = new VendedorDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
