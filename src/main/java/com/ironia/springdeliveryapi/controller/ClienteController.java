package com.ironia.springdeliveryapi.controller;

import com.ironia.springdeliveryapi.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        Cliente c1 = new Cliente();
        c1.setId(1L);
        c1.setNome("Raí");
        c1.setTelefone("98364-78232");
        c1.setEmail("rai@ironia.com");

        Cliente c2 = new Cliente();
        c2.setId(2L);
        c2.setNome("Jana");
        c2.setTelefone("98364-78232");
        c2.setEmail("jana@corna.com");

        List<Cliente> lc = List.of(c1, c2);

        return lc;
    }
}
