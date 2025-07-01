package com.julia.inventrack.repository;

import com.julia.inventrack.model.Historico;
import com.julia.inventrack.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer> {

    List<Historico> findByIdProduto(Integer idProduto);
}
