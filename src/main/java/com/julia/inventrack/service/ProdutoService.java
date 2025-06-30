package com.julia.inventrack.service;

import com.julia.inventrack.model.Produto;
import com.julia.inventrack.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional
    public void salvarProduto(Produto produto) {
        produto.setData(LocalDate.now());
        produtoRepository.save(produto);
    }

    public void deleteProduto(Integer id){
        produtoRepository.deleteById(id);
    }

    @Transactional
    public void alterarProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    public Produto findByID(Integer id){
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (optionalProduto.isPresent()){
            return optionalProduto.get();
        } else {
            return new Produto();
        }
    }

    public List<Produto> findAll(){
        List<Produto> produtos = produtoRepository.findAll();
        return produtos;
    }
}
