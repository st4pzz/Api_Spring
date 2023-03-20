package com.mensagens.projeto.demo.usuarios;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Usuario salvarUsuarios(@RequestBody @Valid Usuario usuario) {

        return usuarioService.salvarUsuario(usuario);
    }
    
    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{identifier}")
    public Usuario getUsuario(@PathVariable String identifier) {
        
        return usuarioService.getUsuario(identifier);
    }

    
}
