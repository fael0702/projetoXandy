package com.atividadefy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atividadefy.model.entity.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    
	boolean existsById(Long id);

	Optional<Tarefa> findById(Long id);

}
