package com.th.agendador_tarefas.infrastructure.security;


import com.th.agendador_tarefas.buisness.dto.UsuarioDto;
import com.th.agendador_tarefas.infrastructure.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl   {

    // Repositório para acessar dados de usuário no banco de dados
    @Autowired
    UsuarioClient client;



    public UserDetails carregaDadosUsuario(String token,String email){
        UsuarioDto dto = client.buscarUsuarioPorEmail(email,token);
        return User
                .withUsername(dto.getEmail()) // Define o nome de usuário como o e-mail
                .password(dto.getSenha()) // Define a senha do usuário
                .build(); // Constrói o objeto UserDetails
    }
}
