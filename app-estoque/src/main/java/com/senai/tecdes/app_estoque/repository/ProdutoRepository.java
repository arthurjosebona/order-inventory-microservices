package com.senai.tecdes.app_estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.tecdes.app_estoque.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
