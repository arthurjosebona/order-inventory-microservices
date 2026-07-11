package com.senai.tecdes.app_estoque.dto;

import lombok.Builder;

@Builder
public record ProdutoDTO(
    Long id,
    String nome,
    Double preco,
    Integer quantidadeEstoque
) {}
