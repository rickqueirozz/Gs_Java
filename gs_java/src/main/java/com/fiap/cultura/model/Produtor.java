package com.fiap.cultura.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produtores")
public class Produtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cnpj;
    private String website;
    private String redesSociais;
    private String biografia;
} 