package me.gabu.gabazar.livros.adapters.http.in.dto;

import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.gabu.gabazar.livros.adapters.http.in.dto.mapper.LivroDTOMapper;
import me.gabu.gabazar.livros.core.model.Livro;

@Getter
@Setter
@ToString
public class LivroDTO {

    @ApiParam(value = "GUID de identificação", example = "5bbce790-fc0d-4f8f-a177-a6f782600af2")
    private String id;

    @ApiParam(value = "Nome do Livro", example = "José Silva")
    private @NotBlank String nome;

    @ApiParam(value = "Documento", example = "11.111.111-1")
    private @NotBlank String documento;

    @ApiParam(value = "E-mail de contato", example = "jose.silva@mail.com")
    private @Email @NotBlank String email;

    @ApiParam(value = "Endereço", example = "Av. Brasil, 10 - São Paulo/SP - CEP 00.000-000")
    private @NotBlank String endereco;

    private String usuarioCriacao;
    private String usuarioAlteracao;

    private @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") Date dataCriacao;
    private @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") Date dataAlteracao;

    public Livro toModel() {
        return LivroDTOMapper.INSTANCE.dtoToModel(this);
    }

    public static LivroDTO fromModel(Livro livro) {
        return LivroDTOMapper.INSTANCE.modelToDto(livro);
    }

    public static Collection<LivroDTO> fromModel(Collection<Livro> livro) {
        return LivroDTOMapper.INSTANCE.modelToDto(livro);
    }
}
