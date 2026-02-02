package com.th.agendador_tarefas.buisness.mapper;

import com.th.agendador_tarefas.buisness.dto.TarefasDto;
import com.th.agendador_tarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaConverter {
    TarefasEntity paraTarefaEntity(TarefasDto dto);
    TarefasDto paraTarefaDto(TarefasEntity entity);

}
