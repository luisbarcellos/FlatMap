package br.com.flatmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
    private String modelo;
    private Set<String> proprietario;

    public void addProprietario(String proprietario){
        if(Objects.isNull(this.proprietario))
            this.proprietario = new HashSet<>();

        this.proprietario.add(proprietario);
    }
}