package br.com.diego.test_form.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diego.test_form.model.UsuarioModel;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    List<UsuarioModel> findAll();
    List<UsuarioModel> findByNome(String nome);
    List<UsuarioModel> findByEmail(String email);
    List<UsuarioModel> findBySenha(String senha);

}