package com.fiap.cultura.controller;

import com.fiap.cultura.dto.EventoRequestCreate;
import com.fiap.cultura.model.Evento;
import com.fiap.cultura.service.EventoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/eventos")
@Tag(name = "Eventos", description = "API para gerenciamento de eventos culturais")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping("/criar")
    @Operation(summary = "Criar um novo evento cultural")
    public ResponseEntity<Evento> criarEvento(@RequestBody EventoRequestCreate request) {
        return ResponseEntity.ok(eventoService.criarEvento(request));
    }

    @GetMapping("/cidade/{cidade}")
    @Operation(summary = "Buscar eventos por cidade")
    public ResponseEntity<List<Evento>> buscarPorCidade(@PathVariable String cidade) {
        return ResponseEntity.ok(eventoService.buscarPorCidade(cidade));
    }

    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Buscar eventos por categoria cultural")
    public ResponseEntity<List<Evento>> buscarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(eventoService.buscarPorCategoria(categoria));
    }

    @GetMapping("/artista/{artista}")
    @Operation(summary = "Buscar eventos por artista")
    public ResponseEntity<List<Evento>> buscarPorArtista(@PathVariable String artista) {
        return ResponseEntity.ok(eventoService.buscarPorArtista(artista));
    }

    @GetMapping("/ingressos-disponiveis")
    @Operation(summary = "Buscar eventos com ingressos disponíveis")
    public ResponseEntity<List<Evento>> buscarComIngressosDisponiveis() {
        return ResponseEntity.ok(eventoService.buscarComIngressosDisponiveis());
    }

    @GetMapping("/estatisticas")
    @Operation(summary = "Obter estatísticas dos eventos")
    public ResponseEntity<Object> obterEstatisticas() {
        return ResponseEntity.ok(eventoService.obterEstatisticas());
    }
} 