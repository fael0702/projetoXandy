package com.atividadefy.model.repository;

import com.atividadefy.model.entity.Tarefa;
import com.atividadefy.repository.TarefaRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TarefaRepositoryTest {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void devePersistirUmaTarefaNaBaseDeDados() {
        
        Tarefa tarefa = criarTarefa();

     
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);

     
        assertThat(tarefaSalva.getId()).isNotNull();
    }

    @Test
    public void deveBuscarUmaTarefaPorNome() {
   
        Tarefa tarefa = criarTarefa();
        entityManager.persist(tarefa);

     
        Tarefa tarefaEncontrada = tarefaRepository.findById("Tarefa de Teste");

        assertThat(tarefaEncontrada).isNotNull();
        assertThat(tarefaEncontrada.getNome()).isEqualTo("Tarefa de Teste");
    }

    @Test
    public void deveRetornarNuloAoBuscarTarefaPorNomeQuandoNaoExistirNaBase() {
    
        Tarefa tarefaEncontrada = tarefaRepository.findByNome("Tarefa Inexistente");

        assertThat(tarefaEncontrada).isNull();
    }

    @Test
    public void deveVerificarAExistenciaDeUmaTarefaPorNome() {
    
        Tarefa tarefa = criarTarefa();
        entityManager.persist(tarefa);

   
        boolean resultado = tarefaRepository.existsByNome("Tarefa de Teste");

    
        assertThat(resultado).isTrue();
    }

    @Test
    public void deveRetornarFalsoQuandoNaoHouverTarefaCadastradaComONome() {
        // Ação
        boolean resultado = tarefaRepository.existsByNome("Tarefa Inexistente");

        // Verificação
        assertThat(resultado).isFalse();
    }

    private Tarefa criarTarefa() {
        return new Tarefa("Tarefa de Teste", "Descrição da Tarefa", "Pendente",
                "Observações da Tarefa", LocalDateTime.now(), LocalDateTime.now());
    }
}
