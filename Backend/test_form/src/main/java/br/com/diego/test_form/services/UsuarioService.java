package br.com.diego.test_form.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diego.test_form.model.UsuarioModel;
import br.com.diego.test_form.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioBD;

    public List<UsuarioModel> obterUsuarios()
    {
        return usuarioBD.findAll();
    }
    public UsuarioModel getUsuarioBDById(Long id) throws Exception
    {
     UsuarioModel usuarioModel = usuarioBD.findById(id).orElseThrow(() -> new Exception("UsuarioModel não encontrado com o ID: " + id));
     return usuarioModel;
    }
    public UsuarioModel criarUsuarioModel(UsuarioModel UsuarioModel) throws Exception
    {
        UsuarioModel usuarioModel2 = usuarioBD.save(UsuarioModel);
        return usuarioModel2;
    }
    public UsuarioModel atualizarUsuarioModel(Long id, UsuarioModel UsuarioModelDetails) throws Exception {

        UsuarioModel UsuarioModel = usuarioBD.findById(id)
                .orElseThrow(() -> new Exception("UsuarioModel não encontrado com o ID: " + id));

        UsuarioModel.setNome(UsuarioModelDetails.getNome());
        UsuarioModel.setEmail(UsuarioModelDetails.getEmail());
        UsuarioModel.setSenha(UsuarioModelDetails.getSenha());

        usuarioBD.save(UsuarioModel);

        return UsuarioModel;
    }
    public String getNomeById(Long id) 
    {
        return usuarioBD.findById(id).get().getNome();
    }
    public String getEmailById(Long id)
    {
        return usuarioBD.findById(id).get().getEmail();
    }
    public void deletar(Long id) {
        UsuarioModel sintomaDeletado = usuarioBD.findById(id).get();
        usuarioBD.delete(sintomaDeletado);
    }
}
