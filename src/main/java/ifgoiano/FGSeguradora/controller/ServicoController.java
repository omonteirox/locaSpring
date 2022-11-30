package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.ServicoDTO;
import ifgoiano.FGSeguradora.models.Servico;
import ifgoiano.FGSeguradora.service.ServicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Serviço",description = "Tudo sobre Serviços")
@RequestMapping("/servico")
public class ServicoController {

    @Autowired
    public ServicoService service;

    @ApiOperation(value = "Consultar Serviço")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ServicoDTO> findById(@PathVariable Long id) {
        ServicoDTO objDTO = new ServicoDTO(service.findById(id));
        return ResponseEntity.ok().body(objDTO);
    }
    @ApiOperation(value = "Criar Serviço")
    @PostMapping
    public ResponseEntity<ServicoDTO> create(@Valid @RequestBody ServicoDTO objDTO) {
        Servico newObj = service.create(objDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @ApiOperation(value = "Listar todos Serviços")
    @GetMapping
    public ResponseEntity<List<ServicoDTO>> findAll() {
        List<ServicoDTO> listDTO = service.findAll()
                .stream().map(obj -> new ServicoDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }
    @ApiOperation(value = "Atualizar Serviço")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ServicoDTO> update(@PathVariable Long id, @Valid @RequestBody ServicoDTO objDTO) {
        ServicoDTO newObj = new ServicoDTO(service.update(id, objDTO));
        return ResponseEntity.ok().body(newObj);

    }
    @ApiOperation(value = "Deletar Serviço")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
