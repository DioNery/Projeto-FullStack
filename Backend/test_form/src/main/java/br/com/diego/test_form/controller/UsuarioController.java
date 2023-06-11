package br.com.diego.test_form.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.diego.test_form.model.UsuarioModel;
import org.springframework.http.HttpStatus;
import br.com.diego.test_form.services.UsuarioService;



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
	public UsuarioModel createUsuario(@RequestBody UsuarioModel usuarioModel) throws Exception {
		return usuario.criarUsuarioModel(usuarioModel);
	}
	 //READ
	@GetMapping("/Usuarios/{id}")
	@ResponseBody
	public ResponseEntity<UsuarioModel> getUsuarioById(@PathVariable Long id)  throws Exception {
		UsuarioModel usuarioSelecionado = usuario.getUsuarioBDById(id);
		return ResponseEntity.ok(usuarioSelecionado);
	}
	//Função para Retornar apenas um nome baseado na ID
	@RequestMapping(value = "/Usuarios/nomes/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getNomeUsuarioById(@PathVariable Long id)  throws Exception {
		String usuarioSelecionado = usuario.getNomeById(id);
				// .orElseThrow(() -> new Exception("Usuario não existe com a id :" + id));
		return ResponseEntity.ok(usuarioSelecionado);
	}
	@RequestMapping(value = "/Usuarios/emails/{id}", method = RequestMethod.GET)
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
	public ResponseEntity<Map<String, Boolean>> deleteUsuario(@PathVariable Long id) throws Exception{
		usuario.deletar(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

  
}
