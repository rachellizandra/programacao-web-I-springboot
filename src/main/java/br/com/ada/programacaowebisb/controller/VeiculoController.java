package br.com.ada.programacaowebisb.controller;

import br.com.ada.programacaowebisb.model.Veiculo;
import br.com.ada.programacaowebisb.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> createVeiculo(@RequestBody Veiculo veiculo) {
        try{
            this.veiculoService.createVeiculo(veiculo);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("Veículo cadastrado!");
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/listar")
    public List<Veiculo> listarTodos(){
        return this.veiculoService.listarTodos();
    }

//    @GetMapping("/by/{id}")
//    public List<Veiculo> listarVeiculoId(@PathVariable("id") Long id){
//        return this.veiculoService.listarVeiculoId(id);
//    }
}
