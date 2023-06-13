package br.com.diego.test_form.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.diego.test_form.model.UsuarioModel;
import org.springframework.http.HttpStatus;
import br.com.diego.test_form.services.UsuarioService;


@CrossOrigin(origins = "http://localhost:5173/cadastro")

@RestController
@RequestMapping("/api/v1/")
public class UsuarioController {
	@Autowired
	UsuarioService usuario;

	//OBSERVAÇÃO IMPORTANTE: O ResponseStatus
	// e ResponseBody São os responsáveis por transformar em arquivo JSON
   
   	@GetMapping("/Usuarios")
	@ResponseBody
	public List<UsuarioModel> getAllUsuarioModels() {
		return usuario.obterUsuarios();
	}
    //CREATE
	@PostMapping("/Usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<?> createUsuario(@RequestBody UsuarioModel usuarioModel) throws Exception {
		UsuarioModel user = usuario.criarUsuarioModel(usuarioModel);
		return ResponseEntity.ok(user);
	}
	@PutMapping("/Usuarios")
	@ResponseBody
	public ResponseEntity<UsuarioModel> atualizarUsuario(@RequestBody UsuarioModel usuarioModelDetails) throws Exception {
		Long id = 2L;
		UsuarioModel usuarioModel = usuario.atualizarUsuarioModel(id, usuarioModelDetails);
		return ResponseEntity.ok(usuarioModel);
	}
	 //READ
	@GetMapping("/Usuarios/{id}")
	@ResponseBody
	public ResponseEntity<UsuarioModel> getUsuarioById(@PathVariable Long id)  throws Exception {
		UsuarioModel usuarioSelecionado = usuario.getUsuarioBDById(id);
		return ResponseEntity.ok(usuarioSelecionado);
	}
	//Função para Retornar apenas um nome baseado na ID
	@GetMapping("/Usuarios/nomes/{id}")
	@ResponseBody
	public ResponseEntity<String> getNomeUsuarioById(@PathVariable Long id)  throws Exception {
		String usuarioSelecionado = usuario.getNomeById(id);
				// .orElseThrow(() -> new Exception("Usuario não existe com a id :" + id));
		return ResponseEntity.ok(usuarioSelecionado);
	}
	@GetMapping("/Usuarios/emails/{id}")
	@ResponseBody
	public ResponseEntity<String> getEmailUsuarioById(@PathVariable Long id)  throws Exception {
		String usuarioSelecionado = usuario.getEmailById(id);
				// .orElseThrow(() -> new Exception("Usuario não existe com a id :" + id));
		return ResponseEntity.ok(usuarioSelecionado);
	}

   
  
    //UPDATE
    @PutMapping("/Usuarios/{id}")
	@ResponseBody
	public ResponseEntity<UsuarioModel> updateUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioModelDetails) throws Exception{
		UsuarioModel usuarioSelecionado = usuario.atualizarUsuarioModel(id, usuarioModelDetails);
		return ResponseEntity.ok(usuarioSelecionado);
	}
    //DELETE
    @DeleteMapping("/Usuarios/{id}")
	@ResponseBody
	public ResponseEntity<String> deleteUsuario(@PathVariable Long id) throws Exception{
		usuario.deletar(id);
		String response = "Deletado";
		return ResponseEntity.ok(response);
	}

  
}
