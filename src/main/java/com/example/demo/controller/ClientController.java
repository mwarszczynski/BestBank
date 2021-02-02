package com.example.demo.controller;

import com.example.demo.mappers.ClientDtoMapper;
import com.example.demo.model.dto.ClientDTO;
import com.example.demo.model.entity.Client;
import com.example.demo.service.ClientService;
import com.example.demo.utils.AccountNumberGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/v1/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    @Autowired
    private ClientService clientService;
    @Autowired
    private AccountNumberGenerator helper;

    @GetMapping("/clients")
    public List<ClientDTO> getClients(Integer page, Sort.Direction sort) {
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;

        return ClientDtoMapper.mapToClientDTO(clientService.getClients(pageNumber, sortDirection));
    }

    @GetMapping("/clients/{id}")
    public ClientDTO getClientById(@PathVariable Long id) {
        Client client = clientService.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Client with id: " + id + " does not exist"));

        return ClientDtoMapper.mapToClientDTO(client);
    }

    @PutMapping("/clients/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        Client client = clientService.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Client with id: " + id + " does not exist"));

        client.setFirstName(clientDetails.getFirstName());
        client.setLastName(clientDetails.getLastName());

        Client updatedClient = clientService.addClient(client);
        return ResponseEntity.ok(updatedClient);
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteClient(@PathVariable Long id) {
        Client client = clientService.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Client with id: " + id + " does not exist"));

        clientService.delete(client);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Client removed", Boolean.TRUE);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

}