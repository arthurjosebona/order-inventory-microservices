package com.senai.tecdes.app_pedidos.model;

import com.senai.tecdes.app_pedidos.model.enums.StatusPedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "t_sgp_pedido")
@Table(name = "t_sgp_pedido")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "produto_id", nullable = false)
    private Long produtoId;
    @Column(name = "vl_qtd_estoque", nullable = false)
    private Integer quantidadePedida;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status;
}
