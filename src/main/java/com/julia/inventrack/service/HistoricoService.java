package com.julia.inventrack.service;

import com.julia.inventrack.model.Historico;
import com.julia.inventrack.model.Produto;
import com.julia.inventrack.repository.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class HistoricoService {

    @Autowired
    HistoricoRepository historicoRepository;

    @Transactional
    public void salvarHistorico(Historico historico) {
        historico.setData(LocalDate.now());
        historicoRepository.save(historico);
    }

    public List<Historico> findAll(){
        return historicoRepository.findAll();
    }

    public List<Historico> findByIdProduto(Integer idProduto){
        return historicoRepository.findByIdProduto(idProduto);
    }
}
