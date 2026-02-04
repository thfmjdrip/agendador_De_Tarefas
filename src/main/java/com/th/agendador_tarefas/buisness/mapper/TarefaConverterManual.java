package com.th.agendador_tarefas.buisness.mapper;

import com.th.agendador_tarefas.buisness.dto.TarefasDto;
import com.th.agendador_tarefas.infrastructure.entity.TarefasEntity;
import org.springframework.stereotype.Component;

@Component
public class TarefaConverterManual {

    public TarefasEntity paraEntity(TarefasDto dto){
        return TarefasEntity.builder()
                .dataCriacao(dto.getDataCriacao())
                .descricao(dto.getDescricao())
                .emailDoUsuario(dto.getEmailDoUsuario())
                .nomeTarefa(dto.getNomeTarefa())
                .dataEvento(dto.getDataEvento())
                .build();
    }

}
