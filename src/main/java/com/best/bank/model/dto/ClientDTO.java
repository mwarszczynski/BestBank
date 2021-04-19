package com.best.bank.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
    @JsonIgnore
    private Long clientId;
    private String fullName;
    private String clientPesel;
    @JsonIgnore
    private long clientLoginId;
}