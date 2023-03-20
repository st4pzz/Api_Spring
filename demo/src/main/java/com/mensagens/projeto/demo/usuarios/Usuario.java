package com.mensagens.projeto.demo.usuarios;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mensagens.projeto.demo.mensagens.Mensagens;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String identifier;
    private String nome;
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Mensagens> mensagens;
    
}
