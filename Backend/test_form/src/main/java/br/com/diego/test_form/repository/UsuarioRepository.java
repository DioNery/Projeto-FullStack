package br.com.diego.test_form.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.diego.test_form.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    UsuarioModel findByNomeAndEmail(String nome, String email);
    List<UsuarioModel> findByNomeOrEmail(String nome, String email);
    List<UsuarioModel> findByNomeIsNull();
    List<UsuarioModel> findByNomeIsNotNull();
    List<UsuarioModel> findByNomeLike(String nome);
    List<UsuarioModel> findByNomeNotLike(String nome);
}