package com.best.bank.repository;

import com.best.bank.model.entity.Client;
import com.best.bank.model.entity.ClientAccounts;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "SELECT * FROM CLIENTS c WHERE c.loginId = :loginId", nativeQuery = true)
    Client findByLoginId(long loginId);

    @Query(value = "SELECT * FROM CLIENTS c WHERE c.pesel = :pesel", nativeQuery = true)
    Client findByPesel(long pesel);

    @Query(value = "SELECT * FROM CLIENTS", nativeQuery = true)
    List<Client> findAllClients();

    @Query(value = "SELECT * FROM CLIENTS", nativeQuery = true)
    List<Client> findAllClients(Pageable pageable);

//    @Query("SELECT a FROM CLIENT a" + " left join fetch a.clientaccounts")
//    List<ClientAccounts> findAllClientAccounts(String id);
}