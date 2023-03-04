package br.com.ada.programacaowebisb.controller;

import br.com.ada.programacaowebisb.model.Veiculo;
import br.com.ada.programacaowebisb.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/cadastrar")
    public void createVeiculo(@RequestBody Veiculo veiculo) {
        this.veiculoService.createVeiculo(veiculo);
    }

    @GetMapping("/buscar")
    public Veiculo buscarVeiculo() {
        return this.veiculoService.buscarVeiculo();
    }
}
