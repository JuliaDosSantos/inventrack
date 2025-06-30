package com.julia.inventrack.controller;

import com.julia.inventrack.model.Produto;
import com.julia.inventrack.model.SucessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.julia.inventrack.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/create")
    public SucessResponse criarProduto(@RequestBody Produto produto) {
        produtoService.salvarProduto(produto);
        return SucessResponse.build("Produto cadastrado com sucesso");
    }

    @DeleteMapping("/delete")
    public SucessResponse deleteProduto(@PathVariable Integer id){
        produtoService.deleteProduto(id);
        return SucessResponse.build("Produto deletado com sucesso");
    }

    @PutMapping("/alterar")
    public SucessResponse alterarProduto(@RequestBody Produto produto) {
        produtoService.alterarProduto(produto);
        return SucessResponse.build("Produto atualizado com sucesso");
    }

    @GetMapping("/find-by-id")
    public Produto findById(@PathVariable Integer id){
        return produtoService.findByID(id);
    }

    @GetMapping("/find-all")
    public List<Produto> findAll(){
        return produtoService.findAll();
    }
}
