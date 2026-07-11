package com.senai.tecdes.app_pedidos.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.senai.tecdes.app_pedidos.client.EstoqueClient;
import com.senai.tecdes.app_pedidos.dto.PedidoRequestDTO;
import com.senai.tecdes.app_pedidos.dto.PedidoResponseDTO;
import com.senai.tecdes.app_pedidos.dto.ProdutoDTO;
import com.senai.tecdes.app_pedidos.mapper.PedidoMapper;
import com.senai.tecdes.app_pedidos.model.Pedido;
import com.senai.tecdes.app_pedidos.model.enums.StatusPedido;
import com.senai.tecdes.app_pedidos.repository.PedidoRepository;

import feign.FeignException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final EstoqueClient estoqueClient;

    @Transactional
    public ResponseEntity<PedidoResponseDTO> create(PedidoRequestDTO request) {
        if (request.quantidadePedida() == null || request.quantidadePedida() <= 0) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "A quantidade pedida deve ser maior que zero");
        }
        ProdutoDTO produto = buscarProdutoDoCliente(request.pedidoId());
        if (produto == null) {
            // Retorna 404 se retornou do cliente tmb
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(savePedido(request, produto));
    }

    private ProdutoDTO buscarProdutoDoCliente(Long pedidoId) {
        try {
            return estoqueClient.obterProdutoPorId(pedidoId);
        } catch (FeignException.NotFound e) {
            // Se der not found eu retorno null, para eu retornar 404 aqui também
            return null;
        }

    }
    
    private PedidoResponseDTO savePedido(PedidoRequestDTO request, ProdutoDTO produto) {
        Pedido pedido = buildarPedido(request, produto);
        pedidoRepository.save(pedido);
        return PedidoMapper.mapToDto(pedido);
    }

    private Pedido buildarPedido(PedidoRequestDTO request, ProdutoDTO produto) {
        return Pedido.builder()
            .produtoId(request.pedidoId())
            .quantidadePedida(request.quantidadePedida())
            .status(
                produto.quantidadeEstoque() >=request.quantidadePedida() ? StatusPedido.APROVADO : StatusPedido.REJEITADO
            )
            .build();
    }
}
