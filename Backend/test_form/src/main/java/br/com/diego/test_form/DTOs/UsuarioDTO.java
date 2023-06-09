package br.com.diego.test_form.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {
    private Long id;
    private String nome;
    private String email;
    private Long endereco_id;
}
