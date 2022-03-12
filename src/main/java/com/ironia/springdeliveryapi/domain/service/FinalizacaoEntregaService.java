package com.ironia.springdeliveryapi.domain.service;

import com.ironia.springdeliveryapi.domain.model.Entrega;
import com.ironia.springdeliveryapi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private BuscaEntregaService buscaEntregaService;
    private EntregaRepository entregaRepository;

    @Transactional
    public void finalizar(Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        entrega.finalizar();

        entregaRepository.save(entrega);
    }
}
