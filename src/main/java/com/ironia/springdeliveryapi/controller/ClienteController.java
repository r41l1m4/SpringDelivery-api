package com.ironia.springdeliveryapi.controller;

import com.ironia.springdeliveryapi.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class ClienteController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        return entityManager.createQuery("from Cliente", Cliente.class)
                .getResultList();
    }
}
