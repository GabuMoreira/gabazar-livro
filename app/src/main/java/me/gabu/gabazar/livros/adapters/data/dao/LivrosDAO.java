package me.gabu.gabazar.livros.adapters.data.dao;

import java.util.Collection;

import me.gabu.gabazar.livros.core.model.Livro;

public interface LivroDAO {

    public Livro findById(String id);
    public Livro save(Livro livro);
    public Collection<Livro> listAll();
    public Collection<Livro> findByNome(String name);
    public Livro update(Livro livro);
    public void delete(Livro livro);
}
