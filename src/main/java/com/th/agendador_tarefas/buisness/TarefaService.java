package com.th.agendador_tarefas.buisness;

import com.th.agendador_tarefas.buisness.dto.TarefasDto;
import com.th.agendador_tarefas.buisness.mapper.TarefaConverter;
import com.th.agendador_tarefas.infrastructure.entity.TarefasEntity;
import com.th.agendador_tarefas.infrastructure.enums.StatusEnum;
import com.th.agendador_tarefas.infrastructure.repository.TarefasRepository;
import com.th.agendador_tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefaService {
    private final JwtUtil jwtUtil;
    private final TarefasRepository repository;
    private final TarefaConverter converter;

    public TarefasDto gravarTarefa(TarefasDto dto,String token){
        String email = jwtUtil.extractUsername(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatus(StatusEnum.PENDENTE);
        dto.setEmailDoUsuario(email);
        TarefasEntity entity = converter.paraTarefaEntity(dto);
        return  converter.paraTarefaDto(repository.save(entity));
    }

}
