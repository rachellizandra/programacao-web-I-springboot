package br.com.ada.programacaowebisb.config;

import br.com.ada.programacaowebisb.model.Veiculo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PWIConfiguration {

    @Bean
    public Veiculo getCarro() {
        return new Veiculo();
    }

}
