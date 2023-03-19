package br.com.ada.programacaowebisb.controller;

import br.com.ada.programacaowebisb.VeiculoDTO;
import br.com.ada.programacaowebisb.model.Veiculo;
import br.com.ada.programacaowebisb.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@Controller
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> createVeiculo(@Validated @RequestBody VeiculoDTO veiculo) {
        try{
            Veiculo veiculoDB = Veiculo.builder()
                    .placa(veiculo.getPlaca())
                    .modelo(veiculo.getModelo())
                    .marca(veiculo.getMarca())
                    .tipo(veiculo.getTipo())
                    .disponivel(veiculo.getDisponivel())
                    .build();
            this.veiculoService.createVeiculo(veiculoDB);
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

    @GetMapping("/by/{id}")
    public ResponseEntity<Veiculo> listarVeiculoId(@PathVariable("id") Long id){
        Optional<Veiculo> optionalVeiculo = this.veiculoService.listarVeiculoId(id);

        if(optionalVeiculo.isPresent()){
            return ResponseEntity.ok(optionalVeiculo.get());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("/by/{id}/disponivelEm/{data}")
    public ResponseEntity<Veiculo> buscarVeiculoPor(@PathVariable Long id) {

        Optional<Veiculo> optionalVeiculo = this.veiculoService.buscarVeiculoPorId(id);

        if (optionalVeiculo.isPresent()) {
            return ResponseEntity.ok(optionalVeiculo.get());
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/")
    public ResponseEntity<String> atualizarVeiculo(@RequestBody VeiculoDTO veiculo) {
        //1 - buscar veiculo pela placa
        //2 - atualizar veiculo

        try {
            Optional<Veiculo> optionalVeiculo = this.veiculoService.buscarVeiculoPelaPlaca(veiculo.getPlaca());

            if (optionalVeiculo.isPresent()) {
                Veiculo veiculoPorPlacaDB = optionalVeiculo.get();
                Veiculo veiculoAtualizar = Veiculo.builder().id(veiculoPorPlacaDB.getId())
                        .modelo(veiculo.getModelo())
                        .marca(veiculo.getMarca())
                        .placa(veiculo.getPlaca())
                        .tipo(veiculo.getTipo())
                        .disponivel(veiculo.getDisponivel())
                        .build();
                this.veiculoService.createVeiculo(veiculoAtualizar);

                return ResponseEntity
                        .ok("Veículo atualizado!");
            }
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public void removerVeiculo(@PathVariable Long id){
        this.veiculoService.removerVeiculoPorId(id);
    }
}
