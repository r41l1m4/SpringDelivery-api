package com.ironia.springdeliveryapi.domain.service;

import com.ironia.springdeliveryapi.domain.exception.NegocioException;
import com.ironia.springdeliveryapi.domain.model.Cliente;
import com.ironia.springdeliveryapi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("Cliente não encontrado!"));
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if(emailEmUso) {
            throw new NegocioException("Já existe cliente com esse email.");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
