package com.projetoxandy.atividadefy.model.repository;


import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.atividadefy.model.Tarefa;


@ExtendWith( SpringExtension.class )
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class TarefaRepositoryTest {
	
	@Autowired
	TarefaRepository repository;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void persistirTarefa() {
		//cenário
		Tarefa tarefa = criarTarefa();
		
		//ação
		Tarefa tarefaSalvo = repository.save(tarefa);
		
		//verificação
		Assertions.assertThat(tarefaSalvo.getId()).isNotNull();
	}

	public static Tarefa criarTarefa() {
		return Tarefa.builder()
				.nome("tarefa java")
				.descricao("tarefa para desenvolver um crud usando spring boot")
				.status("ativo")
				.observacoes("nenhuma")
				.build();
	}
	
}
