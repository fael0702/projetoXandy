package com.atividadefy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Entity
@Table(name = "tarefa", schema = "public")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {
	
	@Id
	@Column(name = "id")
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome")
    private String nome;
	
	@Column(name = "descricao")
    private String descricao;
	
	@Column(name = "status")
    private String status;
	
	@Column(name = "observacoes")
    private String observacoes;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

}
