package com.example.MaxMilhas.repository;

import com.example.MaxMilhas.domain.CpfDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CpfRepository extends JpaRepository<CpfDTO, Long> {
    Optional<CpfDTO> findByCpf(String cpf);
}
