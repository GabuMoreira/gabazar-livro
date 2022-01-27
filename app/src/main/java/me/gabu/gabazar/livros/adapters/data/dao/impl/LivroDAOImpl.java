package me.gabu.gabazar.livros.adapters.data.dao.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.livros.adapters.data.dao.LivroDAO;
import me.gabu.gabazar.livros.adapters.data.entity.LivroEntity;
import me.gabu.gabazar.livros.adapters.data.repository.LivroRepository;
import me.gabu.gabazar.livros.core.exceptions.NotFoundException;
import me.gabu.gabazar.livros.core.model.Livro;

@Slf4j
@Service
public class LivroDAOImpl implements LivroDAO {

    private static final String LOG_UPDATE = "[DAO] [UPDATE] [{}]";
    private static final String LOG_PERSIST = "[DAO] [PERSIST] [{}]";

    private @Autowired LivroRepository repository;

    @Override
    public Livro findById(String id) {
        LivroEntity enditoraEntity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Livro não encontrada"));
        return enditoraEntity.toModel();
    }

    @Override
    public Livro save(Livro livro) {
        log.info(LOG_PERSIST, livro);
        return repository.save(LivroEntity.fromModel(livro)).toModel();
    }

    @Override
    public Collection<Livro> listAll() {
        return LivroEntity.toModel(repository.findAll());
    }

    @Override
    public Collection<Livro> findByNome(String name) {
        return LivroEntity.toModel(repository.findByNome(name));
    }

    @Override
    public Livro update(Livro livro) {
        log.info(LOG_UPDATE, livro);
        return repository.save(LivroEntity.fromModel(livro)).toModel();
    }

    @Override
    public void delete(Livro livro) {
        repository.deleteById(livro.getId());
    }

}
