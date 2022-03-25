package com.vidotto.cambioservice.repository;

import com.vidotto.cambioservice.model.Cambio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CambioRepository extends JpaRepository<Cambio, Long>{
    Cambio findByFromAndTo(String from, String to);
}
