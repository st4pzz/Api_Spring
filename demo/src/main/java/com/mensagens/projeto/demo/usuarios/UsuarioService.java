package com.mensagens.projeto.demo.usuarios;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario) {
        usuario.setIdentifier(UUID.randomUUID().toString());
        return usuarioRepository.save(usuario);
    }

    public Usuario getUsuario(String identifier) {
        return usuarioRepository.findByIdentifier(identifier);
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

   
    
}
