package br.com.diego.test_form.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.diego.test_form.model.UsuarioModel;
import br.com.diego.test_form.services.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {

  UsuarioService usuarioService;
  @PostMapping("/api/submit-form")
  public ResponseEntity<String> submitForm(@RequestBody UsuarioModel usuarioModel) {
      try {
          // Lógica para processar e salvar os dados do formulário
          usuarioService.createUsuario(usuarioModel);
          usuarioService.getAllUsuarios();
          // Exemplo de processamento: salvar os dados do formulário em um banco de dados
          // Aqui, vamos apenas imprimir os dados recebidos para fins de demonstração
          System.out.println("Dados do formulário recebidos:");
          System.out.println("Nome de usuário: " + usuarioModel.getNome());
          System.out.println("Senha: " + usuarioModel.getSenha());
  
          // Simulação de salvamento bem-sucedido
          Boolean dadosSalvos = usuarioModel.getNome() != null && usuarioModel.getSenha() != null;
  
          if (dadosSalvos) {
              // Retornar uma resposta de sucesso
              return ResponseEntity.ok("Dados do formulário salvos com sucesso!");
          } else {
              // Retornar uma resposta de erro
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar os dados do formulário.");
          }
      } catch (Exception e) {
          // Tratar qualquer exceção que possa ocorrer durante o processamento
          // Por exemplo, validações de dados, erros de banco de dados, etc.
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar o formulário.");
      }
  }
  @GetMapping("/submit-form")
  public ModelAndView ver()
  {
    ModelAndView mv = new ModelAndView();
    return mv;
  }

}
