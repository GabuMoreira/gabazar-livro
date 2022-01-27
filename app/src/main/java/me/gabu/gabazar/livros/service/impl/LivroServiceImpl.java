package me.gabu.gabazar.livros.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.gabu.gabazar.livros.core.model.Livro;
import me.gabu.gabazar.livros.core.usecases.ApagarLivroUseCase;
import me.gabu.gabazar.livros.core.usecases.AtualizarLivroUseCase;
import me.gabu.gabazar.livros.core.usecases.ConsultarLivroUseCase;
import me.gabu.gabazar.livros.core.usecases.CriarLivroUseCase;
import me.gabu.gabazar.livros.core.usecases.ListarLivrosUseCase;
import me.gabu.gabazar.livros.service.LivroService;

@Service
public class LivroServiceImpl implements LivroService {

    private @Autowired CriarLivroUseCase criarLivro;
    private @Autowired ConsultarLivroUseCase consultarLivro;
    private @Autowired AtualizarLivroUseCase atualizarLivro;
    private @Autowired ListarLivrosUseCase listarLivros;
    private @Autowired ApagarLivroUseCase apagarLivro;

    @Override
    public Livro criarLivro(Livro livro, String usuario) {
        return criarLivro.run(livro, usuario);
    }

    @Override
    public Livro consultarLivro(String livroId) {
        return consultarLivro.run(livroId);
    }

    @Override
    public Livro atualizarLivro(Livro livro, String usuario) {
        return atualizarLivro.run(livro, usuario);
    }

    @Override
    public Collection<Livro> listarLivros(String nome) {
        return listarLivros.run(nome);
    }

    @Override
    public void apagarLivro(String livroId, String usuario) {
        apagarLivro.run(livroId, usuario);
    }

}
