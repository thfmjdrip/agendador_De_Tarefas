package com.th.agendador_tarefas.buisness.mapper;

import com.th.agendador_tarefas.buisness.dto.TarefasDto;
import com.th.agendador_tarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaConverter {
    @Mapping(source = "id",target = "id")
    @Mapping(source = "dataEvento",target = "dataEvento")
    @Mapping(source = "dataCriacao",target = "dataCriacao")
    TarefasEntity paraTarefaEntity(TarefasDto dto);
    TarefasDto paraTarefaDto(TarefasEntity entity);
    List<TarefasEntity> paraListaTarefasEntity(List<TarefasDto> dtos);
    List<TarefasDto>paraListaTarefasDto(List<TarefasEntity> entities);

}
