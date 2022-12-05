package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.SeguroDTO;
import ifgoiano.FGSeguradora.models.Seguro;
import ifgoiano.FGSeguradora.service.SeguroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@Api(tags = "Seguro",description = "Tudo sobre Seguro")
@RequestMapping("/seguro")
public class SeguroController {


    @Autowired
    public SeguroService service;
    @ApiOperation(value = "Consultar Seguro")
    @GetMapping(value = "/{id}")
    public ResponseEntity<SeguroDTO> findById(@PathVariable Long id) {
        SeguroDTO objDTO = new SeguroDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }
    @ApiOperation(value = "Criar Seguro")
    @PostMapping
    public ResponseEntity<SeguroDTO> create(@Valid @RequestBody SeguroDTO objDTO) {
        Seguro newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @ApiOperation(value = "Atualizar Seguro")
    @PutMapping(value = "/{id}")
    public ResponseEntity<SeguroDTO> update(@PathVariable Long id, @Valid @RequestBody SeguroDTO objDTO) {
        SeguroDTO newObj = new SeguroDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);
    }
    @ApiOperation(value = "Deletar Seguro")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
