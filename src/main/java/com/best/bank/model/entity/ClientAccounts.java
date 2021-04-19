package com.best.bank.model.entity;

import com.best.bank.model.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "ClientAccounts")
public class ClientAccounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "clientId", referencedColumnName = "clientId", insertable = false, updatable = false)
    private Client client;

    private AccountType accountType;
    private int accountNumber;
    private float accountBalance;
}
