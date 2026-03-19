package com.ex6.exercicio6.controllers;

import com.ex6.exercicio6.models.ClienteModel;
import com.ex6.exercicio6.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(name = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll(){
        List<ClienteModel> clienteModelList = clienteService.findAll();

        return ResponseEntity.ok().body(clienteModelList);
    }

    @PostMapping
    public ResponseEntity<ClienteModel> criarCliente(@RequestBody ClienteModel clienteModel){
        ClienteModel novoCliente = clienteService.criarCliente(clienteModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clienteModel.getId()).toUri();

        return ResponseEntity.created(uri).body(novoCliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClienteModel>> findById(@PathVariable Long id){
        Optional<ClienteModel> clienteModelOptional = clienteService.findById(id);

        return ResponseEntity.ok().body(clienteModelOptional);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);

        return ResponseEntity.noContent().build();
    }

}
