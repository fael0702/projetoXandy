package com.projetoxandy.atividadefy.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.atividadefy.repository.TarefaRepository;
import com.atividadefy.service.impl.TarefaServiceImpl;


@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class TarefaServiceTest {
	
	@SpyBean
	TarefaServiceImpl service;
	
	@MockBean
	TarefaRepository repository;
}