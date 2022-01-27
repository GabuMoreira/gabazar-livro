package me.gabu.gabazar.livros.adapters.http.out;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import me.gabu.gabazar.livros.adapters.http.out.dto.EditoraDTO;

@FeignClient(value = "EditoraClient", url = "http://localhost")
public interface EditoraClient {

    @GetMapping("/editoras/{editoraID}")
    EditoraDTO getEditora(@PathVariable("editoraID")String editoraID);

}
