package com.ironia.springdeliveryapi.domain.repository;

import com.ironia.springdeliveryapi.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // o nome desse método segue uma padronização, o final (no caso "Nome") deve seguir o exato nome do
    //atributo ao qual estamos nos referindo.
    List<Cliente> findByNome(String nome);

    List<Cliente> findByNomeContaining(String nome);

    Optional<Cliente> findByEmail(String email);
}
