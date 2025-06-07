package com.fiap.cultura.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produtor_id")
    private Produtor produtor;

    @Embedded
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
} 