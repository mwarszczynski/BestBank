package com.best.bank.controller;

import com.best.bank.model.dto.ClientDTO;
import com.best.bank.model.entity.Client;
import com.best.bank.model.entity.ClientAccounts;
import com.best.bank.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    private final ClientService clientService;

    @GetMapping("/client/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    ClientDTO getClientById(@PathVariable String id) {
        return clientService.findClientById(id);
    }

    @GetMapping("/client/loginid/{loginid}")
    @ResponseStatus(HttpStatus.OK)
    ClientDTO getClientByLoginId(@PathVariable String loginid) {
        return clientService.findClientByLoginId(loginid);
    }

    @GetMapping("/client/pesel/{pesel}")
    @ResponseStatus(HttpStatus.OK)
    ClientDTO getClientByPesel(@PathVariable String pesel) {
        return clientService.findClientByPesel(pesel);
    }

    @GetMapping("/clients")
    Iterable<ClientDTO> getAllClients() {
        return clientService.findAllClients();
    }

    @GetMapping("/clientsPagination")
    Iterable<ClientDTO> getAllClientsPagination(@RequestParam(required = false, defaultValue = "1") Integer pageNumber,
                                                @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return clientService.findAllClientsPagination(pageNumber, pageSize);
    }

    @SneakyThrows
    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.CREATED)
    public Client createClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @DeleteMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable String id) {
        clientService.deleteClient(id);
    }

    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client updateClient(@PathVariable String id, @RequestBody Client client) {
        return clientService.updateClient(id, client);
    }

//    @GetMapping("/client/accounts")
//    public List<ClientAccounts> getClientAccounts(@PathVariable String id) {
//        return clientService.findAllClientAccounts(id);
//    }


//    @GetMapping("/clients/accounts")
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<List<ClientAccounts>> getAllClientAccounts() {
//        List<ClientAccounts> clientAccounts = clientService.findAllClientAccounts();
//        return new ResponseEntity(clientAccounts, HttpStatus.OK);
//    }

}