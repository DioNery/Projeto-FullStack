package br.com.diego.test_form.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.diego.test_form.model.UsuarioModel;
import org.springframework.http.HttpStatus;
import br.com.diego.test_form.repository.UsuarioRepository;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UsuarioController {
	@Autowired
    UsuarioRepository usuarioRepository;

   @RequestMapping(value = "/Usuarios", method = RequestMethod.GET)
	@ResponseBody
	public List<UsuarioModel> getAllUsuarioModels() {
		return usuarioRepository.findAll();
	}
    //CREATE
    @PostMapping("/Usuarios")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public UsuarioModel createUsuario(@RequestBody UsuarioModel usuarioModel) {
		return usuarioRepository.save(usuarioModel);
	}
    //READ
    @GetMapping("/Usuarios/{id}")
	public ResponseEntity<UsuarioModel> getUsuarioById(@PathVariable Long id) throws Exception {
		UsuarioModel usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new Exception("Usuario não existe com a id :" + id));
		return ResponseEntity.ok(usuario);
	}
    //UPDATE
    @PutMapping("/Usuarios/{id}")
	public ResponseEntity<UsuarioModel> updateUsuario(@PathVariable Long id, @RequestBody UsuarioModel usuarioModelDetails) throws Exception{
		UsuarioModel usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new Exception("Usuario não existe com a id :" + id));
		
		usuario.setNome(usuarioModelDetails.getNome());
		usuario.setSenha(usuarioModelDetails.getSenha());
		usuario.setEmail(usuarioModelDetails.getEmail());
		
		UsuarioModel updatedUsuario = usuarioRepository.save(usuario);
		return ResponseEntity.ok(updatedUsuario);
	}
    //DELETE
    @DeleteMapping("/Usuarios/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUsuario(@PathVariable Long id) throws Exception{
		UsuarioModel usuario = usuarioRepository.findById(id)
				.orElseThrow(() -> new Exception("Usuario não existe com a id :" + id));
		usuarioRepository.delete(usuario);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

  
}
