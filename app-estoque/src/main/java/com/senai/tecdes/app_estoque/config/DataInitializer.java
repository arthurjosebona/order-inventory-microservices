package com.senai.tecdes.app_estoque.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.senai.tecdes.app_estoque.model.Produto;
import com.senai.tecdes.app_estoque.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final ProdutoRepository repository;

    @Override
    public void run(String... args) throws Exception {
        criarProdutosIniciais();
    }

    private void criarProdutosIniciais() {
        // Cria com IDs 1 e 2 pq o banco é em memória e são os 2 primeiros a serem criados
        List<Produto> produtosIniciais = List.of(
            Produto.builder()
                .nome("Produto 1")
                .quantidadeEstoque(10)
                .preco(12.78)
                .build(),
            Produto.builder()
                .nome("Produto 2")
                .quantidadeEstoque(0)
                .preco(99.99)
                .build()
        );
        repository.saveAll(produtosIniciais);
        
    }
}