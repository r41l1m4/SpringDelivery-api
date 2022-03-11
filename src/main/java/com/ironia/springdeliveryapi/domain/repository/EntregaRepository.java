package com.ironia.springdeliveryapi.domain.repository;

import com.ironia.springdeliveryapi.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {


}
