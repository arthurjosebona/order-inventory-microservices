package com.senai.tecdes.app_estoque.controller;

import org.springframework.web.bind.annotation.RestController;

import com.senai.tecdes.app_estoque.dto.ProdutoDTO;
import com.senai.tecdes.app_estoque.mapper.ProdutoMapper;
import com.senai.tecdes.app_estoque.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoRepository produtoRepository;

    @GetMapping("/produtos/{id}")
    public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
        return produtoRepository.findById(id)
            .map(p -> ResponseEntity.ok(ProdutoMapper.mapToDto(p)))
            .orElse(ResponseEntity.notFound().build());
    }
    
}
