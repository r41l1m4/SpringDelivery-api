package com.ironia.springdeliveryapi.domain.service;

import com.ironia.springdeliveryapi.domain.exception.NegocioException;
import com.ironia.springdeliveryapi.domain.model.Cliente;
import com.ironia.springdeliveryapi.domain.model.Entrega;
import com.ironia.springdeliveryapi.domain.model.StatusEntrega;
import com.ironia.springdeliveryapi.domain.repository.ClienteRepository;
import com.ironia.springdeliveryapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {

    private EntregaRepository entregaRepository;
    private CatalogoClienteService catalogoClienteService;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);
    }
}
