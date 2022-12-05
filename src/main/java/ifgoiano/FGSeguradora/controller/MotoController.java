package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.MotoDTO;
import ifgoiano.FGSeguradora.mapper.AutomovelMapper;
import ifgoiano.FGSeguradora.models.Automovel;
import ifgoiano.FGSeguradora.service.MotoService;
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
@Api(tags = "Moto",description = "Tudo sobre Moto")
@RequestMapping("/moto")
public class MotoController {
    public final MotoService service;
    private final AutomovelMapper mapper;

    public MotoController(MotoService service, AutomovelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @ApiOperation(value = "Consultar Moto")
    @GetMapping(value = "/{id}")
    public ResponseEntity<MotoDTO> findById(@PathVariable Long id) {
        MotoDTO objDTO = new MotoDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }

    @ApiOperation(value = "Criar Moto")
    @PostMapping
    public ResponseEntity<MotoDTO> create(@Valid @RequestBody MotoDTO objDTO) {
        Automovel newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ApiOperation(value = "Listar todos os Carros")
    @GetMapping
    public ResponseEntity<List<MotoDTO>> findAll() {
        List<MotoDTO> listDTO = service.findAll()
                .stream().map(obj -> new MotoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @ApiOperation(value = "Atualizar Moto")
    @PutMapping(value = "/{id}")
    public ResponseEntity<MotoDTO> update(@PathVariable Long id, @Valid @RequestBody MotoDTO objDTO) {
        MotoDTO newObj = new MotoDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }

    @ApiOperation(value = "Deletar Moto")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
