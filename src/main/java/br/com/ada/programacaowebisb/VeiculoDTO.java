package br.com.ada.programacaowebisb;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoDTO {
    private String placa;
    private String marca;

    @NotBlank(message = "Modelo não pode ser vazio")
    private String modelo;
    private String tipo;
    private Boolean disponivel;
}
