package br.com.diego.test_form.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import jakarta.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "Usuarios")
public class UsuarioModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "nome")
        private String nome;

        @Column(name = "email")
        private String email;

        @Column(name = "senha")
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