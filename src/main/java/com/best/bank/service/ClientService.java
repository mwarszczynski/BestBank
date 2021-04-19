package com.best.bank.service;

import com.best.bank.exceptions.ClientByIdNotFoundException;
import com.best.bank.exceptions.ClientByLoginIdNotFoundException;
import com.best.bank.exceptions.ClientByPeselNotFoundException;
import com.best.bank.exceptions.ClientByPeselAlreadyExistException;
import com.best.bank.mappers.ClientMapper;
import com.best.bank.model.dto.ClientDTO;
import com.best.bank.model.entity.Client;
import com.best.bank.model.entity.ClientAccounts;
import com.best.bank.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientDTO findClientById(final String id) {
        final Client client = findById(id);
        return clientMapper.clientToDTO(client);
    }

    public Client findById(String id) {
        return clientRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ClientByIdNotFoundException("Client with id '" + id + "' not found."));
    }

    public ClientDTO findClientByLoginId(String loginid) {
        final Client client = findByLoginId(loginid);
        return clientMapper.clientToDTO(client);
    }

    Client findByLoginId(String loginid) {
        return Optional.ofNullable(clientRepository.findByLoginId(Long.parseLong(loginid)))
                .orElseThrow(() -> new ClientByLoginIdNotFoundException("Client with loginid '" + loginid + "' not found."));
    }

    public ClientDTO findClientByPesel(String pesel) {
        final Client client = findByPesel(pesel);
        return clientMapper.clientToDTO(client);
    }

    public Client findByPesel(String pesel) {
        return Optional.ofNullable(clientRepository.findByPesel(Long.parseLong(pesel)))
                .orElseThrow(() -> new ClientByPeselNotFoundException("Client with PESEL '" + pesel + "' not found."));
    }

    public Client findByPeselWithoutException(String pesel) {
        return clientRepository.findByPesel(Long.parseLong(pesel));
    }

    public List<ClientDTO> findAllClients() {
        final List<Client> clients = (clientRepository.findAll());
        return clientMapper.clientToDtoList(clients);
    }

    public List<ClientDTO> findAllClientsPagination(Integer pageNumber, Integer pageSize) {
        final List<Client> clients = (clientRepository.findAllClients(PageRequest.of(pageNumber - 1, pageSize)));
        return clientMapper.clientToDtoList(clients);
    }

    public Client addClient(Client client) {
        Client ifClientExist = findByPeselWithoutException(String.valueOf(client.getPesel()));

        if (ifClientExist != null) {
            throw new ClientByPeselAlreadyExistException("Client with indicated PESEL: '" +
                    client.getPesel() + "' already exist in database");
        } else {
            return clientRepository.save(client);
        }
    }

    public void deleteClient(String id) {
        clientRepository.deleteById(Long.valueOf(id));
    }

    public Client updateClient(String id, Client clientToUpdate) {
        Client client = findById(id);

        client.setFirstName(clientToUpdate.getFirstName());
        client.setLastName(clientToUpdate.getLastName());
        client.setPesel(clientToUpdate.getPesel());

        return clientRepository.save(client);
    }

//    public List<ClientAccounts> findAllClientAccounts(String id) {
//        return clientRepository.findAllClientAccounts(id);
//    }
}