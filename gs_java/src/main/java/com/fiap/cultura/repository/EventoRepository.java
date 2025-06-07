package com.fiap.cultura.repository;

import com.fiap.cultura.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByCidade(String cidade);
    List<Evento> findByCategoria(String categoria);
    List<Evento> findByArtista(String artista);
    List<Evento> findByCapacidadeGreaterThan(Integer capacidade);

    @Query("SELECT e.categoria as categoria, COUNT(e) as total FROM Evento e GROUP BY e.categoria")
    Map<String, Long> countByCategoria();

    @Query("SELECT e.cidade as cidade, COUNT(e) as total FROM Evento e GROUP BY e.cidade")
    Map<String, Long> countByCidade();

    @Query("SELECT AVG(e.precoIngresso) FROM Evento e")
    Double findAveragePrecoIngresso();
} 