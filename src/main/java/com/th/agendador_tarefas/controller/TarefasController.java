package com.th.agendador_tarefas.controller;

import com.th.agendador_tarefas.buisness.TarefaService;
import com.th.agendador_tarefas.buisness.dto.TarefasDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
