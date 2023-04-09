package com.mensagens.projeto.demo.mensagens;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    private MensagensService mensagensService;

    @GetMapping
    public List<Mensagens> getMensagens() {
        return mensagensService.AllMensagens();
    }

    @PostMapping("/mensagemText/{identifier}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public MensagemTexto salvarMensagemTexto(@PathVariable String identifier,@RequestBody @Valid MensagemTexto mensagemTexto) {
        return mensagensService.salvarMensagemTexto(mensagemTexto,identifier);
        }

    @PostMapping("/mensagemArquivo/{identifier}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public MensagemArquivo salvarMensagemArquivo(@PathVariable String identifier,@RequestBody @Valid MensagemArquivo mensagemArquivo) {
        return mensagensService.salvarMensagemArquivo(mensagemArquivo,identifier);
        }

    @GetMapping("/{identifier}")
    public Mensagens getMensagem(@PathVariable String identifier) {
    
        return mensagensService.getMensagem(identifier);
    }

    @GetMapping("/user/{identifier}")
    public List<Mensagens> getMensagemUser(@PathVariable String identifier) {
        return mensagensService.getMensagensUser(identifier);
    }

}