package com.fiap.cultura.service;

import com.fiap.cultura.dto.EventoRequestCreate;
import com.fiap.cultura.model.Evento;
import com.fiap.cultura.repository.EventoRepository;
import com.fiap.cultura.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Evento criarEvento(EventoRequestCreate request) {
        Evento evento = new Evento();
        evento.setUsuario(usuarioRepository.findById(request.getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado")));
        evento.setEndereco(request.getEndereco());
        evento.setCep(request.getCep());
        evento.setCidade(request.getCidade());
        evento.setCategoria(request.getCategoria());
        evento.setNome(request.getNome());
        evento.setDescricao(request.getDescricao());
        evento.setArtista(request.getArtista());
        evento.setDataHora(request.getDataHora());
        evento.setCapacidade(request.getCapacidade());
        evento.setPrecoIngresso(request.getPrecoIngresso());
        evento.setTipoIngresso(request.getTipoIngresso());
        evento.setLocal(request.getLocal());
        evento.setOrganizador(request.getOrganizador());
        evento.setContato(request.getContato());
        evento.setSite(request.getSite());
        evento.setRedesSociais(request.getRedesSociais());
        return eventoRepository.save(evento);
    }

    @Cacheable(value = "eventosPorCidade", key = "#cidade")
    public List<Evento> buscarPorCidade(String cidade) {
        return eventoRepository.findByCidade(cidade);
    }

    @Cacheable(value = "eventosPorCategoria", key = "#categoria")
    public List<Evento> buscarPorCategoria(String categoria) {
        return eventoRepository.findByCategoria(categoria);
    }

    @Cacheable(value = "eventosPorArtista", key = "#artista")
    public List<Evento> buscarPorArtista(String artista) {
        return eventoRepository.findByArtista(artista);
    }

    @Cacheable("eventosComIngressosDisponiveis")
    public List<Evento> buscarComIngressosDisponiveis() {
        return eventoRepository.findByCapacidadeGreaterThan(0);
    }

    public Map<String, Object> obterEstatisticas() {
        Map<String, Object> estatisticas = new HashMap<>();
        estatisticas.put("totalEventos", eventoRepository.count());
        estatisticas.put("eventosPorCategoria", eventoRepository.countByCategoria());
        estatisticas.put("eventosPorCidade", eventoRepository.countByCidade());
        estatisticas.put("mediaPrecoIngressos", eventoRepository.findAveragePrecoIngresso());
        return estatisticas;
    }
} 