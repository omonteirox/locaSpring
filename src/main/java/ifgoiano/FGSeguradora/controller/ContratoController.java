package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.ContratoDTO;
import ifgoiano.FGSeguradora.DTO.GerenteDTO;
import ifgoiano.FGSeguradora.models.Contrato;
import ifgoiano.FGSeguradora.service.ContratoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/contrato")
@Api(tags = "Contrato",description = "Tudo sobre Contrato")
public class ContratoController {
    public final ContratoService service;

    public ContratoController(ContratoService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Consultar Contrato")
    public ResponseEntity<ContratoDTO> findById(@PathVariable Long id) {
        ContratoDTO objDTO = new ContratoDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @PostMapping
    @ApiOperation(value = "Criar Contrato")
    public ResponseEntity<ContratoDTO> create(@Valid @RequestBody ContratoDTO objDTO) {
        Contrato newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    @ApiOperation(value = "Listar todos Contratos")
    public ResponseEntity<List<ContratoDTO>> findAll() {
        List<ContratoDTO> listDTO = service.findAll()
                .stream().map(obj -> new ContratoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualizar Contrato")
    public ResponseEntity<ContratoDTO> update(@PathVariable Long id, @Valid @RequestBody ContratoDTO objDTO) {
        ContratoDTO newObj = new ContratoDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deletar Contrato")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
