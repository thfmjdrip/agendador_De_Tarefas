package com.th.agendador_tarefas.controller;

import com.th.agendador_tarefas.buisness.TarefaService;
import com.th.agendador_tarefas.buisness.dto.TarefasDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefasController {
    private TarefaService service;

    @PostMapping
    public ResponseEntity<TarefasDto> gravarTarefas(@RequestBody TarefasDto dto,
                                                    @RequestHeader("Authorization") String token){
        return ResponseEntity.ok(service.gravarTarefa(dto,token));
    }

    @GetMapping("/eventos")
    public ResponseEntity<List<TarefasDto>>buscaListaPorPeriodo(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataInicial,
                                                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)LocalDateTime dataFinal){
        return  ResponseEntity.ok(service.buscaTarefasAgendadasPorPeriodo(dataInicial,dataFinal));
    }

    @GetMapping
    public ResponseEntity<List<TarefasDto>> buscaTarefasPorEmail(@RequestHeader("Authorization")String token){
        return  ResponseEntity.ok(service.buscaTarefasPorEmail(token));
    }
}
