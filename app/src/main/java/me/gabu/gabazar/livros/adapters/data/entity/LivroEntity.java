package me.gabu.gabazar.livros.adapters.data.entity;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.livros.adapters.data.entity.mapper.LivroEntityMapper;
import me.gabu.gabazar.livros.core.model.Livro;

@Getter
@Setter
@Entity
@Slf4j
@ToString
@Table(name = "TBGB_LIVR")
public class LivroEntity {

    @Id
    private String id;
    private String nome;
    private String email;
    private String documento;
    private String endereco;
    private Date dataCriacao;
    private Date dataAlteracao;
    private String usuarioCriacao;
    private String usuarioAlteracao;

    @PrePersist
    public void prePersist() {
        id = UUID.randomUUID().toString();
        dataCriacao = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        dataAlteracao = new Date();
    }

    @PostPersist
    public void postPersist() {
        log.info("[ENTITY] [POS-PERSIST] Usuario {} cadastrou o Livro {}", usuarioCriacao, this);
    }

    @PostUpdate
    public void postUpdate() {
        log.info("[ENTITY] [POS-UPDATE] Usuario {} atualizou os dados do Livro {}", usuarioAlteracao, this);
    }

    @PostRemove
    public void postRemoval() {
        log.info("[ENTITY] [POS-REMOVAL] Usuario {} apagou o Livro {}", usuarioAlteracao, this);
    }

    public Livro toModel() {
        return LivroEntityMapper.INSTANCE.entityToModel(this);
    }

    public static Collection<Livro> toModel(Collection<LivroEntity> livros) {
        return LivroEntityMapper.INSTANCE.entityToModel(livros);
    }

    public static LivroEntity fromModel(Livro livro) {
        return LivroEntityMapper.INSTANCE.modelToEntity(livro);
    }

    public static Collection<LivroEntity> fromModel(Collection<Livro> livro) {
        return LivroEntityMapper.INSTANCE.modelToEntity(livro);
    }
}
