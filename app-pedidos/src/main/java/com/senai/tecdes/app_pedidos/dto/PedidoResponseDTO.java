package com.senai.tecdes.app_pedidos.dto;

import com.senai.tecdes.app_pedidos.model.enums.StatusPedido;

import lombok.Builder;

@Builder
public record PedidoResponseDTO(
    Long id,
    Long produtoId,
    Integer quantidadePedida,
    StatusPedido status
) {}
