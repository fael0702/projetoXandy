package com.atividadefy.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atividadefy.model.Tarefa;
import com.atividadefy.repository.TarefaRepository;
import com.atividadefy.service.TarefaService;

@Service
public class TarefaServiceImpl implements TarefaService {
	
	private TarefaRepository repository;
	
	public TarefaServiceImpl(TarefaRepository repository) {
		super();
		this.repository = repository;
	}
	
	@Override
	@Transactional
	public Tarefa salvarTarefa(Tarefa tarefa) {
		return repository.save(tarefa);
	}
}