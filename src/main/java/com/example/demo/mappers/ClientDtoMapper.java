package com.example.demo.mappers;

import com.example.demo.model.dto.ClientDTO;
import com.example.demo.model.entity.Client;

import java.util.List;
import java.util.stream.Collectors;

public class ClientDtoMapper {

    private ClientDtoMapper() {
    }

    public static List<ClientDTO> mapToClientDTO(List<Client> clients) {
        return clients.stream()
                .map(ClientDtoMapper::mapToClientDTO)
                .collect(Collectors.toList());
    }

    public static ClientDTO mapToClientDTO(Client client) {
        return ClientDTO.builder()
                .client_id(client.getClient_id())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .loginId(client.getLoginId())
                .build();
    }

}
