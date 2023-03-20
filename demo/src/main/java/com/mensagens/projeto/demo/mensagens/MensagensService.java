package com.mensagens.projeto.demo.mensagens;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mensagens.projeto.demo.usuarios.Usuario;
import com.mensagens.projeto.demo.usuarios.UsuarioService;

@Service
public class MensagensService {

    @Autowired
    private MensagensRepository mensagensRepository;

    @Autowired
    private UsuarioService usuarioService;

    public MensagemTexto salvarMensagemTexto(MensagemTexto mensagemTexto,String identifier) {
        mensagemTexto.setIdentifier(UUID.randomUUID().toString());
        Usuario usuario = usuarioService.getUsuario(identifier);
        mensagemTexto.setUsuario(usuario);
        return mensagensRepository.save(mensagemTexto);
    }

    public MensagemArquivo salvarMensagemArquivo(MensagemArquivo mensagemArquivo,String identifier) {
        mensagemArquivo.setIdentifier(UUID.randomUUID().toString());
        Usuario usuario = usuarioService.getUsuario(identifier);
        mensagemArquivo.setUsuario(usuario);
        return mensagensRepository.save(mensagemArquivo);
    }

    public Mensagens getMensagem(String identifier) {
        return mensagensRepository.findByIdentifier(identifier);
    }

    public List<Mensagens> getMensagensUser(String identifier) {
        Usuario usuario = usuarioService.getUsuario(identifier);
        return mensagensRepository.findByUsuario(usuario);   
    }

    public List<Mensagens> AllMensagens ()  {
        return mensagensRepository.findAll();
    }

}
