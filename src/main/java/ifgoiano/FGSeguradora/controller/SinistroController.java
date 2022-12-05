package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.ContratoDTO;
import ifgoiano.FGSeguradora.DTO.SinistroDTO;
import ifgoiano.FGSeguradora.models.Sinistro;
import ifgoiano.FGSeguradora.service.SinistroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/sinistro")
@Api(tags = "Sinistro",description = "Tudo sobre Sinistro")
public class SinistroController {
    private final SinistroService service;

    public SinistroController(SinistroService service) {
        this.service = service;
    }


    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Consultar Contrato")
    public ResponseEntity<SinistroDTO> findById(@PathVariable Long id) {
        SinistroDTO objDTO = new SinistroDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @PostMapping
    @ApiOperation(value = "Criar Sinistro")
    public ResponseEntity<SinistroDTO> create(@Valid @RequestBody SinistroDTO objDTO) {
        Sinistro newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    @ApiOperation(value = "Listar todos Sinitros")
    public ResponseEntity<List<SinistroDTO>> findAll() {
        List<SinistroDTO> listDTO = service.findAll()
                .stream().map(obj -> new SinistroDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualizar Sinistro")
    public ResponseEntity<SinistroDTO> update(@PathVariable Long id, @Valid @RequestBody SinistroDTO objDTO) {
        SinistroDTO newObj = new SinistroDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deletar Sinistro")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
