package com.senai.tecdes.app_pedidos.mapper;

import com.senai.tecdes.app_pedidos.dto.PedidoResponseDTO;
import com.senai.tecdes.app_pedidos.model.Pedido;

public class PedidoMapper {
    public static PedidoResponseDTO mapToDto(Pedido entity) {
        return PedidoResponseDTO.builder()
            .id(entity.getId())
            .produtoId(entity.getProdutoId())
            .quantidadePedida(entity.getQuantidadePedida())
            .status(entity.getStatus())
            .build();
    }
}
