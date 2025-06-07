package com.fiap.cultura.dto;

import com.fiap.cultura.model.Localizacao;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ShowRequestCreate {
    private Long idProdutor;
    private Localizacao localizacao;
    private String cep;
    private String cidade;
    private String genero;
    private String titulo;
    private String sinopse;
    private String artista;
    private LocalDateTime dataHora;
    private Integer lotacao;
    private BigDecimal valorIngresso;
    private String tipoIngresso;
    private String casa;
    private String promotor;
    private String telefone;
    private String website;
    private String redesSociais;

    // Getters e Setters
    public Long getIdProdutor() {
        return idProdutor;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public String getGenero() {
        return genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public String getArtista() {
        return artista;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public BigDecimal getValorIngresso() {
        return valorIngresso;
    }

    public String getTipoIngresso() {
        return tipoIngresso;
    }

    public String getCasa() {
        return casa;
    }

    public String getPromotor() {
        return promotor;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getWebsite() {
        return website;
    }

    public String getRedesSociais() {
        return redesSociais;
    }
} 