package com.best.bank.mappers;

import com.best.bank.model.dto.ClientDTO;
import com.best.bank.model.entity.Client;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "fullName", expression = "java(client.getFirstName() + client.getLastName())")
    @Mapping(target = "clientPesel", source = "pesel")
    ClientDTO clientToDTO(Client client);

    @InheritInverseConfiguration
    List<ClientDTO> clientToDtoList(List<Client> clientsList);
}
