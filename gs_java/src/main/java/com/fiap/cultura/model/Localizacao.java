package com.fiap.cultura.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Localizacao {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String pontoReferencia;
} 