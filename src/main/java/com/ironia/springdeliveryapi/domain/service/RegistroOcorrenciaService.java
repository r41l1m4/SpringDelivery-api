package com.ironia.springdeliveryapi.domain.service;

import com.ironia.springdeliveryapi.domain.model.Entrega;
import com.ironia.springdeliveryapi.domain.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long idEntrega, String descricao) {
        Entrega entrega = buscaEntregaService.buscar(idEntrega);
        return entrega.adicionarOcorrencia(descricao);
    }
}
