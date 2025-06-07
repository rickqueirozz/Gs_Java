package com.fiap.cultura.repository;

import com.fiap.cultura.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    List<Show> findByCidade(String cidade);
    List<Show> findByGenero(String genero);
    List<Show> findByArtista(String artista);
    List<Show> findByLotacaoGreaterThan(Integer lotacao);

    @Query("SELECT s.genero as genero, COUNT(s) as total FROM Show s GROUP BY s.genero")
    Map<String, Long> countByGenero();

    @Query("SELECT s.cidade as cidade, COUNT(s) as total FROM Show s GROUP BY s.cidade")
    Map<String, Long> countByCidade();

    @Query("SELECT AVG(s.valorIngresso) FROM Show s")
    Double findAverageValorIngresso();
} 