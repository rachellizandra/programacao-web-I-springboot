package br.com.ada.programacaowebisb.service;

import br.com.ada.programacaowebisb.model.Veiculo;
import br.com.ada.programacaowebisb.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //irá chamar interface repository
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public void createVeiculo(Veiculo veiculo){
        this.veiculoRepository.save(veiculo);
    }

    public Page<Veiculo> listarPaginado(Integer numeroPagina, Integer tamanhoPagina) {
        return this.veiculoRepository
                .findAll(PageRequest.of(numeroPagina, tamanhoPagina, Sort.by(Sort.Order.asc("id"))));
    }

    public List<Veiculo> listarTodos(){
        return this.veiculoRepository.findAll();
    }

    public Optional<Veiculo> listarVeiculoId(Long id){
        return this.veiculoRepository.findById(id);
    }

    public Optional<Veiculo> buscarVeiculoPlaca(String placa){
        return this.veiculoRepository.findByPlacaContaining(placa);
    }

    public void removerVeiculoPorId(Long id) {
        this.veiculoRepository.deleteById(id);
    }
}
