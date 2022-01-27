package me.gabu.gabazar.livros.service;

import me.gabu.gabazar.livros.core.model.Livro;
import me.gabu.gabazar.livros.service.validations.ValidationEnum;

public interface ValidationService {
    public void validate(Livro livro, ValidationEnum validation);
}
