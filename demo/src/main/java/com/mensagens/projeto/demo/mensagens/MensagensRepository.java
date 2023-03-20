package com.mensagens.projeto.demo.mensagens;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mensagens.projeto.demo.usuarios.Usuario;

public interface MensagensRepository extends JpaRepository<Mensagens, Integer> {
    Mensagens findByIdentifier(String identifier);

    List<Mensagens> findByUsuario(Usuario usuario);
}
