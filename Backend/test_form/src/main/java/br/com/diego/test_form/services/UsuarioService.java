package br.com.diego.test_form.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diego.test_form.model.UsuarioModel;
import br.com.diego.test_form.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuario;

    public List<UsuarioModel> obterUsuarios()
    {
        return usuario.findAll();
    }
    
}
