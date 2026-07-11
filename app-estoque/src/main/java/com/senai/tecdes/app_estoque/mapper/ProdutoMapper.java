package com.senai.tecdes.app_estoque.mapper;

import com.senai.tecdes.app_estoque.dto.ProdutoDTO;
import com.senai.tecdes.app_estoque.model.Produto;

public class ProdutoMapper {
    public static ProdutoDTO mapToDto(Produto produto) {
        return ProdutoDTO.builder()
            .id(produto.getId())
            .preco(produto.getPreco())
            .nome(produto.getNome())
            .quantidadeEstoque(produto.getQuantidadeEstoque())
            .build();
    }
}
