package com.senai.tecdes.app_estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "t_sge_produto")
@Table(name = "t_sge_produto")
@Builder
@Getter
@Setter
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ds_nome", nullable = false)
    private String nome;
    @Column(name = "vl_preco", nullable = false)
    private Double preco;
    @Column(name = "vl_qtd_estoque", nullable = false)
    private Integer quantidadeEstoque;
}
