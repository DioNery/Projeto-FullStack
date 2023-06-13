package br.com.diego.test_form.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diego.test_form.model.SintomasModel;
import br.com.diego.test_form.repository.SintomasRepository;

@Service
public class SintomasService {
    @Autowired
    private SintomasRepository sintomas;

    public List<SintomasModel> obterSintomas()
    {
        return sintomas.findAll();
    }
    public SintomasModel getSintomasById(Long id) throws Exception
    {
        return sintomas.findById(id).get();
    }
    public SintomasModel criarSintomasModel(SintomasModel sintomasModel)
    {
        return sintomas.save(sintomasModel);
    }
    public SintomasModel atualizarSintomasModel(Long id, SintomasModel SintomasModelDetails) throws Exception {

        SintomasModel sintomasModel = sintomas.findById(id)
                .orElseThrow(() -> new Exception("SintomasModel não encontrado com o ID: " + id));

        sintomasModel.setDiarreia(SintomasModelDetails.getDiarreia());
        sintomasModel.setDorDeCabeca(SintomasModelDetails.getDorDeCabeca());
        sintomasModel.setDorMuscular(SintomasModelDetails.getDorMuscular());
        sintomasModel.setSangramento(SintomasModelDetails.getSangramento());
        sintomasModel.setVomito(SintomasModelDetails.getVomito());

        sintomas.save(sintomasModel);

        return sintomasModel;
    }
    public Boolean getDorDeCabecaById(Long id)
    {
        return sintomas.findById(id).get().getDorDeCabeca();
    }
    public Boolean getDorMuscularById(Long id)
    {
        return sintomas.findById(id).get().getDorMuscular();
    }
    public void deletar(Long id) {
        SintomasModel sintomaDeletado = sintomas.findById(id).get();
        sintomas.delete(sintomaDeletado);
    }
}
