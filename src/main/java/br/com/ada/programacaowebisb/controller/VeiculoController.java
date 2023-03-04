package br.com.ada.programacaowebisb.controller;

import br.com.ada.programacaowebisb.model.Veiculo;
import br.com.ada.programacaowebisb.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/cadastrar")
    public void createVeiculo(@RequestBody Veiculo veiculo) {
        this.veiculoService.createVeiculo(veiculo);
    }

    @GetMapping("/listar")
    public List<Veiculo> listarTodos(){
        return this.veiculoService.listarTodos();
    }

    @GetMapping("/by/{id}")
    public List<Veiculo> listarVeiculoId(@PathVariable("id") Long id){
        return this.veiculoService.listarVeiculoId(id);
    }
}
