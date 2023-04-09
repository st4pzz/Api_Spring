package com.mensagens.projeto.demo.mensagens;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MensagemArquivo extends Mensagens{

    private Integer tamanho;
    private String tipo;

}
