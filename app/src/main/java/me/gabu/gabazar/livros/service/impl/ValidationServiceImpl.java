package me.gabu.gabazar.livros.service.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import me.gabu.gabazar.livros.core.exceptions.BadRequestException;
import me.gabu.gabazar.livros.core.model.Livro;
import me.gabu.gabazar.livros.service.ValidationService;
import me.gabu.gabazar.livros.service.validations.Create;
import me.gabu.gabazar.livros.service.validations.Update;
import me.gabu.gabazar.livros.service.validations.ValidationEnum;

@Service
public class ValidationServiceImpl implements ValidationService {

    private @Autowired Validator validator;

    @Override
    public void validate(Livro livro, ValidationEnum validation) {

        Set<ConstraintViolation<Livro>> contraints = getContraints(Livro, validation);

        if (!CollectionUtils.isEmpty(contraints))
            throw new BadRequestException(processaContraint(contraints));

    }

    private Set<ConstraintViolation<Livro>> getContraints(Livro livro, ValidationEnum validation) {
        switch (validation) {
        case CREATE:
            return validator.validate(Livro, Create.class);

        case UPDATE:
        default:
            return validator.validate(Livro, Update.class);
        }
    }

    private List<String> processaContraint(Set<ConstraintViolation<Livro>> contraints) {
        return contraints.stream()
                .map(violation -> String.format("[%s %s]",
                        StreamSupport.stream(violation.getPropertyPath().spliterator(), false)
                                .reduce((first, second) -> second).orElse(null),
                        violation.getMessage()))
                .collect(Collectors.toList());
    }

}
