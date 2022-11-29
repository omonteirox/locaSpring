package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.ContratoDTO;
import ifgoiano.FGSeguradora.models.Contrato;
import ifgoiano.FGSeguradora.service.ContratoService;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/contrato")
public class ContratoController {
    public final ContratoService service;

    public ContratoController(ContratoService service) {
        this.service = service;
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Contrato> findById(@PathVariable Long id) {
        Contrato contratoO = service.findById(id);
       contratoO.add(linkTo(methodOn(ContratoController.class).findAll()).withRel("Olhar todos os contratos"));

//        ContratoDTO objDTO = new ContratoDTO(service.findById(id));
//        return ResponseEntity.ok().body(objDTO);
        return ResponseEntity.ok().body(contratoO);
    }

    @PostMapping
    public ResponseEntity<ContratoDTO> create(@Valid @RequestBody ContratoDTO objDTO) {
        Contrato newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Contrato>> findAll() {
        List<Contrato> contratosList = service.findAll();
        if (contratosList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            contratosList.stream().forEach(p-> p.add(linkTo(methodOn(ContratoController.class).findById(p.getId())).withRel("Acessar no contrato:")));
            }
            return new ResponseEntity<List<Contrato>>(contratosList,HttpStatus.OK);
        }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ContratoDTO> update(@PathVariable Long id, @Valid @RequestBody ContratoDTO objDTO) {
        ContratoDTO newObj = new ContratoDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
