package com.senai.tecdes.app_pedidos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.senai.tecdes.app_pedidos.dto.ProdutoDTO;

// A anotação indica que o Spring deve gerar a implementação deste cliente 
// HTTP automaticamente
@FeignClient(name = "estoque-client", url = "http://localhost:8081")
public interface EstoqueClient {

    // Mapeia o endpoint exato do Microserviço A que retorna o produto
    @GetMapping("/produtos/{id}")
    ProdutoDTO obterProdutoPorId(@PathVariable("id") Long id); 
}