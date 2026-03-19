package com.ex6.exercicio6.repositories;

import com.ex6.exercicio6.models.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
