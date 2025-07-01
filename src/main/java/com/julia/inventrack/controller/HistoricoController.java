package com.julia.inventrack.controller;

import com.julia.inventrack.model.Historico;
import com.julia.inventrack.model.Produto;
import com.julia.inventrack.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    @Autowired
    HistoricoService historicoService;

    @PostMapping("/create")
    public void criarHistorico(@RequestBody Historico historico) {
        historicoService.salvarHistorico(historico);
    }

    @GetMapping("/find-all")
    public List<Historico> findAll(){
        return historicoService.findAll();
    }

    @GetMapping("/find-by-produto")
    public List<Historico> findByIdProduto(@PathVariable Integer idProduto){
        return historicoService.findByIdProduto(idProduto);
    }
}
