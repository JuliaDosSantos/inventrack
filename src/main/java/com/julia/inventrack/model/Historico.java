package com.julia.inventrack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDate data;

    private String tipoMovimentacao;

    private Integer idProduto;

    private String produto;

    private String categoria;

    private Integer quantidade;

    private Integer estoqueAnterior;

    private Integer estoqueAtualizado;
}
