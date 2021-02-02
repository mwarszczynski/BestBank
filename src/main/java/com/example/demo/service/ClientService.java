package com.example.demo.service;

import com.example.demo.model.entity.Client;
import com.example.demo.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private static final int PAGE_SIZE = 5;

    private final ClientRepository clientRepository;

    public List<Client> getClients(int page, Sort.Direction sort) {
        return clientRepository.findAllClients(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "client_id")));
    }

    public Optional<Client> findById(long id) {
        return clientRepository.findById(id);
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Client client) {
        clientRepository.delete(client);
    }
}
