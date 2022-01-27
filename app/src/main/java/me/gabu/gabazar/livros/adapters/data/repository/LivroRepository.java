package me.gabu.gabazar.livros.adapters.data.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.gabu.gabazar.livros.adapters.data.entity.LivroEntity;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, String> {

    Collection<LivroEntity> findByNome(String nome);
}
