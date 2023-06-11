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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.diego.test_form.model.SintomasModel;

import org.springframework.http.HttpStatus;
import br.com.diego.test_form.services.SintomasService;
@RestController
@RequestMapping("/api/v2/")
public class SintomasController {
    

	@Autowired
    SintomasService sintomasService;

	//OBSERVAÇÃO IMPORTANTE: O ResponseStatus
	// e ResponseBody São os responsáveis por transformar em arquivo JSON
   
   	@GetMapping("/Sintomas")
	@ResponseBody
	public List<SintomasModel> getAllSintomasModels() {
		return sintomasService.obterSintomas();
	}
    //CREATE
	@PostMapping("/Sintomas")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<SintomasModel> createSintoma(@RequestBody SintomasModel SintomasModel) {
		 SintomasModel sintoma = sintomasService.criarSintomasModel(SintomasModel);
         return ResponseEntity.ok(sintoma);
	}
	 //READ
	@GetMapping("/Sintomas/{id}")
	@ResponseBody
	public ResponseEntity<SintomasModel> getSintomaById(@PathVariable Long id)  throws Exception {
		SintomasModel Sintoma = sintomasService.getSintomasById(id);
		return ResponseEntity.ok(Sintoma);
	}
	//Função para Retornar apenas um nome baseado na ID
	@GetMapping("/Sintomas/dorDeCabeca/{id}")
	@ResponseBody
	public ResponseEntity<String> getSintomaDorDeCabecaById(@PathVariable Long id)  throws Exception {
		Boolean verificar = sintomasService.getDorDeCabecaById(id);
        String resposta;
        if(verificar)
        {
            resposta = "Ele tem dor de cabeça";
        }
        else{
            resposta = "Ele não tem dor de cabeça";
        }
				// .orElseThrow(() -> new Exception("Sintoma não existe com a id :" + id));
		return ResponseEntity.ok(resposta);
	}
	@GetMapping("/Sintomas/dorDeCabeca/{id}")
	@ResponseBody
	public ResponseEntity<String> getSintomaDorMuscularById(@PathVariable Long id)  throws Exception {
		Boolean verificar = sintomasService.getDorMuscularById(id);
        String resposta;
        if(verificar)
        {
            resposta = "Ele tem dor muscular.";
        }
        else{
            resposta = "Ele não tem dor muscular.";
        }
				// .orElseThrow(() -> new Exception("Sintoma não existe com a id :" + id));
		return ResponseEntity.ok(resposta);
	}

   
  
    //UPDATE
    @PutMapping("/Sintomas/{id}")
	@ResponseBody
	public ResponseEntity<SintomasModel> updateSintomas(@PathVariable Long id, @RequestBody SintomasModel SintomasModelDetails) throws Exception{


		SintomasModel sintomaNovo = sintomasService.atualizarSintomasModel(id, SintomasModelDetails);
        
		return ResponseEntity.ok(sintomaNovo);
	}
    //DELETE
    @DeleteMapping("/Sintomas/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Boolean>> deleteSintoma(@PathVariable Long id) throws Exception{
		sintomasService.deletar(id);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

  

}
