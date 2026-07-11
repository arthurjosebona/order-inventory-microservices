package com.senai.tecdes.app_pedidos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.tecdes.app_pedidos.dto.PedidoRequestDTO;
import com.senai.tecdes.app_pedidos.dto.PedidoResponseDTO;
import com.senai.tecdes.app_pedidos.service.PedidoService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> verificarEstoque(@RequestBody PedidoRequestDTO request) {
        return pedidoService.create(request);
    }
    
}
