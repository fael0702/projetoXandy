package com.atividadefy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atividadefy.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
	boolean existsByName(String name);
	
	Optional<Tarefa> findByName(String name);
}
