package me.gabu.gabazar.livros.core.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.gabu.gabazar.livros.service.validations.Create;
import me.gabu.gabazar.livros.service.validations.Update;

@Getter
@Setter
@ToString
public class Livro {
    private @NotNull(groups = Update.class) String id;
    private @NotNull(groups = { Update.class, Create.class }) String nome;
    private @NotNull(groups = { Update.class, Create.class }) String documento;
    private @NotNull(groups = { Update.class, Create.class }) String endereco;
    private @NotNull(groups = { Update.class, Create.class }) String email;
    
    private @NotNull(groups = { Update.class, Create.class }) String editoraID;
    private @NotNull(groups = { Update.class, Create.class }) String autorID;

    private Date dataCriacao;
    private Date dataAlteracao;
    private String usuarioCriacao;
    private String usuarioAlteracao;
}
