package com.example.demo.repository;

import com.example.demo.model.entity.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "SELECT * FROM CLIENT", nativeQuery = true)
    List<Client> findAllClients(Pageable page);
}
