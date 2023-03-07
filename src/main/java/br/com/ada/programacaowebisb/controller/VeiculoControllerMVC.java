package br.com.ada.programacaowebisb.controller;

import br.com.ada.programacaowebisb.model.Veiculo;
import br.com.ada.programacaowebisb.rest.dto.VeiculoDTO;
import br.com.ada.programacaowebisb.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RestController
@Controller
public class VeiculoControllerMVC {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping("/veiculos")
    public String listarveiculos(Model model) {
        List<Veiculo> veiculos = this.veiculoService.listarTodos();
        model.addAttribute("veiculos", veiculos);
        return "veiculos";
    }

    @GetMapping("/veiculo/add")
    public String buscarVeiculo(Model model) {
        model.addAttribute("add", Boolean.TRUE);
        model.addAttribute("veiculo", new Veiculo());
        return "veiculo-add";
    }

    @PostMapping("/veiculo/add")
    public String criarVeiculo(@ModelAttribute("veiculo") Veiculo veiculo) {
        this.veiculoService.createVeiculo(veiculo);
        return "redirect:/veiculos";
    }

    @GetMapping("/veiculos/{veiculoId}/delete")
    public String deletarVeiculo(@PathVariable("veiculoId") Long veiculoId) {
        this.veiculoService.removerVeiculoPorId(veiculoId);
        return "redirect:/veiculos";
    }

}
