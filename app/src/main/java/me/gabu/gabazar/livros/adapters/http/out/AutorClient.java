package me.gabu.gabazar.livros.adapters.http.out;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import me.gabu.gabazar.livros.adapters.http.out.dto.AutorDTO;

@FeignClient(value = "AutorClient", url = "http://localhost")
public interface AutorClient {

    @GetMapping("/autore/{autorID}")
    AutorDTO getAutor(@PathVariable("autorID") String autorID);
}
