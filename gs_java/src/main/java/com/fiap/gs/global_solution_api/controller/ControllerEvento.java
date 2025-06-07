package com.fiap.gs.global_solution_api.controller;

import com.fiap.gs.global_solution_api.dto.EventoRequestCreate;
import com.fiap.gs.global_solution_api.dto.EventoRequestGet;
import com.fiap.gs.global_solution_api.dto.EventoRequestUpdate;
import com.fiap.gs.global_solution_api.dto.EventoResponse;
import com.fiap.gs.global_solution_api.service.EventoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "*")
@Tag(name = "Eventos Culturais", description = "API para gerenciamento de eventos culturais")
public class ControllerEvento {

    @Autowired
    private EventoService eventoService;

    @PostMapping("/criar")
    @Operation(summary = "Criar novo evento cultural", description = "Cria um novo evento cultural")
    public ResponseEntity<EventoResponse> criarEvento(@RequestBody EventoRequestCreate dto) {
        return ResponseEntity.status(201).body(new EventoResponse().toDto(eventoService.saveEvento(dto)));
    }

    @PutMapping("/atualizar/{id}")
    @Operation(summary = "Atualizar evento", description = "Atualiza um evento cultural existente")
    public ResponseEntity<EventoResponse> atualizarEvento(
            @PathVariable Long id, 
            @RequestBody EventoRequestUpdate dto) {
        return eventoService.update(id, dto)
                .map(evento -> ResponseEntity.status(200).body(new EventoResponse().toDto(evento)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar eventos", description = "Retorna todos os eventos culturais cadastrados")
    public ResponseEntity<List<EventoRequestGet>> listarTodosEventos() {
        return ResponseEntity.ok(eventoService.findAllEventos().stream()
                .map(evento -> new EventoRequestGet().toDto(evento))
                .collect(Collectors.toList()));
    }

    @GetMapping("/buscar/{id}")
    @Operation(summary = "Buscar evento por ID", description = "Retorna um evento cultural específico pelo ID")
    public ResponseEntity<EventoRequestGet> buscarEventoPorId(@PathVariable Long id) {
        return eventoService.findById(id)
                .map(evento -> ResponseEntity.status(200).body(new EventoRequestGet().toDto(evento)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscar/cidade")
    @Operation(summary = "Buscar eventos por cidade", description = "Retorna eventos filtrados por cidade")
    public ResponseEntity<List<EventoRequestGet>> buscarEventosPorCidade(@RequestParam String cidade) {
        return ResponseEntity.ok(eventoService.findAllByCidade(cidade).stream()
                .map(evento -> new EventoRequestGet().toDto(evento))
                .collect(Collectors.toList()));
    }

    @GetMapping("/buscar/categoria")
    @Operation(summary = "Buscar eventos por categoria", description = "Retorna eventos filtrados por categoria cultural")
    public ResponseEntity<List<EventoRequestGet>> buscarEventosPorCategoria(
            @RequestParam String categoria) {
        return ResponseEntity.ok(eventoService.findAllByCategoria(categoria).stream()
                .map(evento -> new EventoRequestGet().toDto(evento))
                .collect(Collectors.toList()));
    }

    @GetMapping("/buscar/data")
    @Operation(summary = "Buscar eventos por data", description = "Retorna eventos filtrados por data")
    public ResponseEntity<List<EventoRequestGet>> buscarEventosPorData(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return ResponseEntity.ok(eventoService.findAllByData(data).stream()
                .map(evento -> new EventoRequestGet().toDto(evento))
                .collect(Collectors.toList()));
    }

    @GetMapping("/buscar/artista")
    @Operation(summary = "Buscar eventos por artista", description = "Retorna eventos filtrados por artista")
    public ResponseEntity<List<EventoRequestGet>> buscarEventosPorArtista(@RequestParam String artista) {
        return ResponseEntity.ok(eventoService.findAllByArtista(artista).stream()
                .map(evento -> new EventoRequestGet().toDto(evento))
                .collect(Collectors.toList()));
    }

    @GetMapping("/buscar/ingressos-disponiveis")
    @Operation(summary = "Buscar eventos com ingressos disponíveis", description = "Retorna eventos que ainda têm ingressos disponíveis")
    public ResponseEntity<List<EventoRequestGet>> buscarEventosComIngressosDisponiveis() {
        return ResponseEntity.ok(eventoService.findAllComIngressosDisponiveis().stream()
                .map(evento -> new EventoRequestGet().toDto(evento))
                .collect(Collectors.toList()));
    }

    @DeleteMapping("/remover/{id}")
    @Operation(summary = "Remover evento", description = "Remove um evento cultural pelo ID")
    public ResponseEntity<Void> removerEvento(@PathVariable long id) {
        boolean result = eventoService.deleteById(id);
        return result ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        }

    @GetMapping("/estatisticas")
    @Operation(summary = "Obter estatísticas", description = "Retorna estatísticas dos eventos culturais")
    public ResponseEntity<Object> obterEstatisticas() {
        return ResponseEntity.ok(eventoService.getEstatisticas());
    }
}