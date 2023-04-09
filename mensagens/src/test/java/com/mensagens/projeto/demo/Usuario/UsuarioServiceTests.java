package com.mensagens.projeto.demo.Usuario;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mensagens.projeto.demo.usuarios.Usuario;
import com.mensagens.projeto.demo.usuarios.UsuarioRepository;
import com.mensagens.projeto.demo.usuarios.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTests {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Test
    public void test_saveUsuario() {

        Usuario usuario = getUsuario();

        Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);
        Usuario resp = usuarioService.salvarUsuario(usuario);

        Assertions.assertEquals(1, resp.getId());
        Assertions.assertEquals("123456", usuario.getIdentifier());
        Assertions.assertEquals(usuario, resp);


    }

    @Test
    public void test_getUsuario() {

        Usuario usuario = getUsuario();

        Mockito.when(usuarioRepository.findByIdentifier(usuario.getIdentifier())).thenReturn(usuario);
        Usuario resp = usuarioService.getUsuario(usuario.getIdentifier());

        Assertions.assertEquals(1, resp.getId());
        Assertions.assertEquals("123456", usuario.getIdentifier());
        Assertions.assertEquals(usuario, resp);

    }

    @Test
    public void test_listUsuarios () {


        Mockito.when(usuarioRepository.findAll()).thenReturn(new ArrayList<>());
        List<Usuario> resp = usuarioService.getUsuarios();

        Assertions.assertEquals(0, resp.size());

    }

    private static Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setIdentifier("123456");
        usuario.setNome("sergio");
        usuario.setEmail("sergio@gmail.com");
        
        return usuario;
    }
    
}
