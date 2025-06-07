package com.fiap.cultura.service;

import com.fiap.cultura.dto.ShowRequestCreate;
import com.fiap.cultura.model.Show;
import com.fiap.cultura.repository.ShowRepository;
import com.fiap.cultura.repository.ProdutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ProdutorRepository produtorRepository;

    public Show criarShow(ShowRequestCreate request) {
        Show show = new Show();
        show.setProdutor(produtorRepository.findById(request.getIdProdutor())
                .orElseThrow(() -> new RuntimeException("Produtor não encontrado")));
        show.setLocalizacao(request.getLocalizacao());
        show.setCep(request.getCep());
        show.setCidade(request.getCidade());
        show.setGenero(request.getGenero());
        show.setTitulo(request.getTitulo());
        show.setSinopse(request.getSinopse());
        show.setArtista(request.getArtista());
        show.setDataHora(request.getDataHora());
        show.setLotacao(request.getLotacao());
        show.setValorIngresso(request.getValorIngresso());
        show.setTipoIngresso(request.getTipoIngresso());
        show.setCasa(request.getCasa());
        show.setPromotor(request.getPromotor());
        show.setTelefone(request.getTelefone());
        show.setWebsite(request.getWebsite());
        show.setRedesSociais(request.getRedesSociais());
        return showRepository.save(show);
    }

    @Cacheable(value = "showsPorCidade", key = "#cidade")
    public List<Show> buscarPorCidade(String cidade) {
        return showRepository.findByCidade(cidade);
    }

    @Cacheable(value = "showsPorGenero", key = "#genero")
    public List<Show> buscarPorGenero(String genero) {
        return showRepository.findByGenero(genero);
    }

    @Cacheable(value = "showsPorArtista", key = "#artista")
    public List<Show> buscarPorArtista(String artista) {
        return showRepository.findByArtista(artista);
    }

    @Cacheable("showsComIngressosDisponiveis")
    public List<Show> buscarComIngressosDisponiveis() {
        return showRepository.findByLotacaoGreaterThan(0);
    }

    public Map<String, Object> obterEstatisticas() {
        Map<String, Object> estatisticas = new HashMap<>();
        estatisticas.put("totalShows", showRepository.count());
        estatisticas.put("showsPorGenero", showRepository.countByGenero());
        estatisticas.put("showsPorCidade", showRepository.countByCidade());
        estatisticas.put("mediaValorIngressos", showRepository.findAverageValorIngresso());
        return estatisticas;
    }
} 