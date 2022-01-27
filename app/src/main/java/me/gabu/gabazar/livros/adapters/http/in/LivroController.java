package me.gabu.gabazar.livros.adapters.http.in;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import me.gabu.gabazar.livros.adapters.http.in.dto.LivroDTO;
import me.gabu.gabazar.livros.core.model.Livro;
import me.gabu.gabazar.livros.service.LivroService;
import me.gabu.gabazar.livros.service.TokenService;

@Slf4j
@Controller
@RequestMapping("/livros")
@Api(value = "Livros", tags = "Livros")
public class LivroController {

    private @Autowired LivroService service;
    private @Autowired TokenService tokenService;

    @PostMapping()
    public @ResponseBody LivroDTO post(@RequestBody LivroDTO livroDTO, @RequestHeader("token") String token) {
        log.info("[POST] [/livros] Request: {}", livroDTO);

        validaToken(token);

        Livro livroCriado = service.criarLivro(livroDTO.toModel(), getUsuario(token));

        return LivroDTO.fromModel(livroCriado);
    }

    @GetMapping("/{id}")
    public @ResponseBody LivroDTO getByID(@PathVariable("id") String id, @RequestHeader("token") String token) {
        log.info("[GET] [/livros/{}]", id);

        validaToken(token);

        return LivroDTO.fromModel(service.consultarLivro(id));
    }

    @PutMapping("/{id}")
    public @ResponseBody LivroDTO put(@PathVariable("id") String id, @RequestHeader("token") String token,
            @RequestBody LivroDTO livroDTO) {
        log.info("[PUT] [/livros/{}] Request: {}", id, livroDTO);

        validaToken(token);

        Livro livro = livroDTO.toModel();
        livro.setId(id);

        return LivroDTO.fromModel(service.atualizarLivro(livro, getUsuario(token)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LivroDTO> delete(@PathVariable("id") String id, @RequestHeader("token") String token) {
        log.info("[DELETE] [/livros/{}]", id);

        validaToken(token);

        service.apagarLivro(id, getUsuario(token));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping
    public @ResponseBody Collection<LivroDTO> get(@RequestParam(required = false) String nome,
            @RequestHeader("token") String token) {
        validaToken(token);

        return LivroDTO.fromModel(service.listarLivros(nome));
    }

    private String getUsuario(String token) {
        return tokenService.recuperarUsuario(token);
    }

    private void validaToken(String token) {
        tokenService.validaToken(token);
    }
}
