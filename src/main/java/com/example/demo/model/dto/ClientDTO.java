package com.example.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDTO {
    private long client_id;
    private String firstName;
    private String lastName;
    @JsonIgnore
    private String loginId;
}
