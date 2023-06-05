package br.com.diego.test_form.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diego.test_form.model.UsuarioModel;
import br.com.diego.test_form.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> getAllUsuarios() {
        return usuarioRepository.findAll();
        }

    public UsuarioModel getUsuarioById(Long id) throws Exception {
        return usuarioRepository.findById(id)
        .orElseThrow(() -> new Exception("Usuario não encontrado"));
        }

    public UsuarioModel createUsuario(UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
        }

    public UsuarioModel updateUsuario(Long id, UsuarioModel usuario) throws Exception {
            UsuarioModel existingUsuario = usuarioRepository.findById(id)
            .orElseThrow(() -> new Exception("Usuario não encontrado"));
            existingUsuario.setNome(usuario.getNome());
            existingUsuario.setEmail(usuario.getEmail());
            return usuarioRepository.save(existingUsuario);
            }

    public void deleteUsuario(Long id) {
                usuarioRepository.deleteById(id);
            }
}
