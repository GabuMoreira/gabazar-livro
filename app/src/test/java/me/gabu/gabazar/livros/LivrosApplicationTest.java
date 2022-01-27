package me.gabu.gabazar.livros;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import me.gabu.gabazar.livros.adapters.http.in.LivroController;
import me.gabu.gabazar.livros.core.usecases.ApagarLivroUseCase;
import me.gabu.gabazar.livros.core.usecases.AtualizarLivroUseCase;
import me.gabu.gabazar.livros.core.usecases.ConsultarLivroUseCase;
import me.gabu.gabazar.livros.core.usecases.CriarLivroUseCase;
import me.gabu.gabazar.livros.core.usecases.ListarLivrosUseCase;
import me.gabu.gabazar.livros.service.LivroService;
import me.gabu.gabazar.livros.service.TokenService;
import me.gabu.gabazar.livros.service.ValidationService;

@SpringBootTest
class LivrosApplicationTest {

    private @Autowired LivroController controller;
    private @Autowired LivroService service;
    private @Autowired TokenService token;
    private @Autowired ValidationService validation;
    private @Autowired ApagarLivroUseCase apagarUC;
    private @Autowired AtualizarLivroUseCase atualizarUC;
    private @Autowired ConsultarLivroUseCase consultarUC;
    private @Autowired CriarLivroUseCase criarUC;
    private @Autowired ListarLivrosUseCase listarUC;

    @Test
    void contextLoads() {
        assertNotNull(controller);
        assertNotNull(service);
        assertNotNull(token);
        assertNotNull(validation);
        assertNotNull(apagarUC);
        assertNotNull(atualizarUC);
        assertNotNull(consultarUC);
        assertNotNull(criarUC);
        assertNotNull(listarUC);
    }

}
