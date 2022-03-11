package com.ironia.springdeliveryapi.api.controller;

import com.ironia.springdeliveryapi.api.assembler.EntregaAssembler;
import com.ironia.springdeliveryapi.api.model.DestinatarioModel;
import com.ironia.springdeliveryapi.api.model.EntregaModel;
import com.ironia.springdeliveryapi.api.model.input.EntregaInput;
import com.ironia.springdeliveryapi.domain.model.Entrega;
import com.ironia.springdeliveryapi.domain.repository.EntregaRepository;
import com.ironia.springdeliveryapi.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaRepository entregaRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaAssembler entregaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaInput entregaInput) {
        return entregaAssembler
                .toModel(solicitacaoEntregaService.solicitar(entregaAssembler.toEntity(entregaInput)));
    }

    @GetMapping
    public List<EntregaModel> listar() {
        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
}
