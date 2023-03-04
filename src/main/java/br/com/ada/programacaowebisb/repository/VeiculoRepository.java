package br.com.ada.programacaowebisb.repository;

import br.com.ada.programacaowebisb.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //se comunica com a base de dados (model)
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
