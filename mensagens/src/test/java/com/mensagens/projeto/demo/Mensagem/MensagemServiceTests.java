package com.mensagens.projeto.demo.Mensagem;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mensagens.projeto.demo.mensagens.MensagemArquivo;
import com.mensagens.projeto.demo.mensagens.MensagemTexto;
import com.mensagens.projeto.demo.mensagens.Mensagens;
import com.mensagens.projeto.demo.mensagens.MensagensRepository;
import com.mensagens.projeto.demo.mensagens.MensagensService;
import com.mensagens.projeto.demo.usuarios.Usuario;



@ExtendWith(MockitoExtension.class)
public class MensagemServiceTests {
    
    @InjectMocks
    private MensagensService mensagemService;

    @Mock
    private MensagensRepository mensagemRepository;

    @Test
    public void test_saveMensagemTexto() {

        MensagemTexto mensagem_texto = getMensagemTexto();

        Mockito.when(mensagemRepository.save(mensagem_texto)).thenReturn(mensagem_texto);
        MensagemTexto resp = mensagemService.salvarMensagemTexto(mensagem_texto, "123456");

        Assertions.assertEquals(1, resp.getId());
        Assertions.assertEquals("123456", mensagem_texto.getIdentifier());
        Assertions.assertEquals("sergio", mensagem_texto.getUsuario().getNome());
        Assertions.assertEquals("spring eh top", mensagem_texto.getTexto());
        
        Assertions.assertEquals(mensagem_texto, resp);
    }
    @Test
    public void test_saveMensagemArquivo() {

        MensagemArquivo mensagem_arquivo = getMensagemArquivo();

        Mockito.when(mensagemRepository.save(mensagem_arquivo)).thenReturn(mensagem_arquivo);
        MensagemArquivo resp = mensagemService.salvarMensagemArquivo(mensagem_arquivo, "123456");

        Assertions.assertEquals(1, resp.getId());
        Assertions.assertEquals("123456", mensagem_arquivo.getIdentifier());
        Assertions.assertEquals("sergio", mensagem_arquivo.getUsuario().getNome());
        Assertions.assertEquals(10, mensagem_arquivo.getTamanho());
        Assertions.assertEquals("pdf", mensagem_arquivo.getTipo());
        Assertions.assertEquals(mensagem_arquivo, resp);
    }

    @Test
    public void test_getMensagem() {
        MensagemTexto mensagem_texto = getMensagemTexto();
        Mockito.when(mensagemRepository.findByIdentifier("123456")).thenReturn(mensagem_texto);
        Mensagens resp = mensagemService.getMensagem("123456");
        Assertions.assertEquals(mensagem_texto, resp);
    }

    @Test
    public void test_listMensagens() {
        List<Mensagens> mensagens = new ArrayList<>();
        mensagens.add(getMensagemTexto());
        mensagens.add(getMensagemArquivo());
        Mockito.when(mensagemRepository.findAll()).thenReturn(mensagens);
        List<Mensagens> resp = mensagemService.AllMensagens();
        Assertions.assertEquals(mensagens, resp);
    }

    @Test
    public void test_getMensagembyUsuario() {
        List<Mensagens> mensagens = new ArrayList<>();
        mensagens.add(getMensagemTexto());
        mensagens.add(getMensagemArquivo());
        Mockito.when(mensagemRepository.findByUsuario(getUsuario())).thenReturn(mensagens);
        List<Mensagens> resp = mensagemService.getMensagensUser(getUsuario().getIdentifier());
        Assertions.assertEquals(mensagens, resp);
    }

    private static Usuario getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setIdentifier("123456");
        usuario.setNome("sergio");
        usuario.setEmail("sergio@gmail.com");
        return usuario;
    }
    private static MensagemTexto getMensagemTexto() {
        MensagemTexto mensagem_texto = new MensagemTexto();
        mensagem_texto.setId(1);
        mensagem_texto.setIdentifier("123456");
        mensagem_texto.setData("10/10/2021");
        mensagem_texto.setTexto("spring eh top");
        mensagem_texto.setUsuario(getUsuario());

        return mensagem_texto;
    }

    private static MensagemArquivo getMensagemArquivo() {
        MensagemArquivo mensagem_arquivo = new MensagemArquivo();
        mensagem_arquivo.setId(1);
        mensagem_arquivo.setIdentifier("123456");
        mensagem_arquivo.setData("10/10/2021");
        mensagem_arquivo.setTamanho(10);
        mensagem_arquivo.setTipo("pdf");
        mensagem_arquivo.setUsuario(getUsuario());
        return mensagem_arquivo;
    }

}
