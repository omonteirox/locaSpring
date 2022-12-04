package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.CaminhoneteDTO;
import ifgoiano.FGSeguradora.mapper.AutomovelMapper;
import ifgoiano.FGSeguradora.models.Automovel;
import ifgoiano.FGSeguradora.service.CaminhoneteService;
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
@Api(tags = "Caminhonete",description = "Tudo sobre Caminhonete")
@RequestMapping("/caminhonete")
public class CaminhoneteController {
    public final CaminhoneteService service;
    private final AutomovelMapper mapper;

    public CaminhoneteController(CaminhoneteService service, AutomovelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }
    @ApiOperation(value = "Consultar Caminhonete")
    @GetMapping(value = "/{id}")
    public ResponseEntity<CaminhoneteDTO> findById(@PathVariable Long id) {
        CaminhoneteDTO objDTO = new CaminhoneteDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }
    @ApiOperation(value = "Criar Caminhonete")
    @PostMapping
    public ResponseEntity<CaminhoneteDTO> create(@Valid @RequestBody CaminhoneteDTO objDTO) {
        Automovel newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @ApiOperation(value = "Listar todas as Caminhonetes")
    @GetMapping
    public ResponseEntity<List<CaminhoneteDTO>> findAll() {
        List<CaminhoneteDTO> listDTO = service.findAll()
                .stream().map(obj -> new CaminhoneteDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @ApiOperation(value = "Atualizar Caminhonete")
    @PutMapping(value = "/{id}")
    public ResponseEntity<CaminhoneteDTO> update(@PathVariable Long id, @Valid @RequestBody CaminhoneteDTO objDTO) {
        CaminhoneteDTO newObj = new CaminhoneteDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }
    @ApiOperation(value = "Deletar Caminhonete")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}