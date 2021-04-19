package com.best.bank.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //    @Column(name = "id")
    private Long clientId;

    //    @Column(name = "loginid")
    private Long loginId;

    //    @Column(name = "firstname")
    private String firstName;

    //    @Column(name = "lastname")
    private String lastName;

    //    @Column(name = "pesel")
    private Long pesel;

    @OneToMany(targetEntity = ClientAccounts.class, mappedBy = "client")
    private Set<ClientAccounts> clientAccounts;

//    @OneToMany(targetEntity = ClientAccounts.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "accountId", updatable = false, insertable = false)
//    private List<ClientAccounts> clientAccounts;
}