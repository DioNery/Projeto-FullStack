package br.com.diego.test_form.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UsuarioModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String senha;
        private String email;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "endereco_id", referencedColumnName = "id")
        private EnderecoModel endereco;
}