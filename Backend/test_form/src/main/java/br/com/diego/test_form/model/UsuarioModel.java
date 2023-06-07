package br.com.diego.test_form.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Usuarios")
public class UsuarioModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String senha;
        private String email;

        public List setLista(List<UsuarioModel> lista)
        {
            this.nome = lista.get(0).getNome();
            this.senha = lista.get(0).getSenha();
            this.email = lista.get(0).getEmail();
            return lista;
        }

}