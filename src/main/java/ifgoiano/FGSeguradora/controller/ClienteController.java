package ifgoiano.FGSeguradora.controller;

import ifgoiano.FGSeguradora.DTO.ClienteCreateDTO;
import ifgoiano.FGSeguradora.DTO.ClienteDTO;
import ifgoiano.FGSeguradora.DTO.MensagemRespostaDTO;
import ifgoiano.FGSeguradora.exception.ObjectNotFoundException;
import ifgoiano.FGSeguradora.mapper.ClienteMapper;
import ifgoiano.FGSeguradora.models.Cliente;
import ifgoiano.FGSeguradora.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cliente")
@Api(tags = "Cliente",description = "Tudo sobre Cliente")
public class ClienteController {
    public final ClienteService service;

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Consultar Cliente")
    public ResponseEntity<Cliente> findById(@PathVariable Long id) throws ObjectNotFoundException {
        Cliente obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    @ApiOperation(value = "Criar Cliente")
    public ResponseEntity<MensagemRespostaDTO> create(@Valid @RequestBody ClienteCreateDTO objDTO) throws ObjectNotFoundException {
        var obj = service.create(objDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @GetMapping
    @ApiOperation(value = "Listar todos Clientes")
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> list= service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualizar Cliente")
    public ResponseEntity<MensagemRespostaDTO> update(@PathVariable Long id, @Valid @RequestBody ClienteCreateDTO objDTO) throws ObjectNotFoundException {
        var newObj = service.update(id, objDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newObj);

    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deletar Cliente")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws ObjectNotFoundException {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
