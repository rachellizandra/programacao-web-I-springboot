package br.com.ada.programacaowebisb.service;

import br.com.ada.programacaowebisb.model.Veiculo;
import br.com.ada.programacaowebisb.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //irá chamar interface repository
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void createVeiculo(Veiculo veiculo){
        this.veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listarTodos(){
        return this.veiculoRepository.findAll();
    }
}
