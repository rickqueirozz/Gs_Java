package com.fiap.cultura.controller;

import com.fiap.cultura.dto.ShowRequestCreate;
import com.fiap.cultura.model.Show;
import com.fiap.cultura.service.ShowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
@Tag(name = "Shows", description = "API para gerenciamento de shows culturais")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/criar")
    @Operation(summary = "Criar um novo show cultural")
    public ResponseEntity<Show> criarShow(@RequestBody ShowRequestCreate request) {
        return ResponseEntity.ok(showService.criarShow(request));
    }

    @GetMapping("/cidade/{cidade}")
    @Operation(summary = "Buscar shows por cidade")
    public ResponseEntity<List<Show>> buscarPorCidade(@PathVariable String cidade) {
        return ResponseEntity.ok(showService.buscarPorCidade(cidade));
    }

    @GetMapping("/genero/{genero}")
    @Operation(summary = "Buscar shows por gênero musical")
    public ResponseEntity<List<Show>> buscarPorGenero(@PathVariable String genero) {
        return ResponseEntity.ok(showService.buscarPorGenero(genero));
    }

    @GetMapping("/artista/{artista}")
    @Operation(summary = "Buscar shows por artista")
    public ResponseEntity<List<Show>> buscarPorArtista(@PathVariable String artista) {
        return ResponseEntity.ok(showService.buscarPorArtista(artista));
    }

    @GetMapping("/ingressos-disponiveis")
    @Operation(summary = "Buscar shows com ingressos disponíveis")
    public ResponseEntity<List<Show>> buscarComIngressosDisponiveis() {
        return ResponseEntity.ok(showService.buscarComIngressosDisponiveis());
    }

    @GetMapping("/estatisticas")
    @Operation(summary = "Obter estatísticas dos shows")
    public ResponseEntity<Object> obterEstatisticas() {
        return ResponseEntity.ok(showService.obterEstatisticas());
    }
} 