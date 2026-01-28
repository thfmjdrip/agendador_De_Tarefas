package com.th.agendador_tarefas.buisness.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDto {
    private String email;
    private String senha;

}
