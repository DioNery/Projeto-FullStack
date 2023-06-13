package br.com.diego.test_form.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.persistence.*;

@Data
@NoArgsConstructor

@Entity
public class UsuarioModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String nome;

        private String email;

        private String senha;

        public UsuarioModel(Long id, String nome, String email, String senha)
        {
            super();
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.senha = senha;
        }
        

       

}