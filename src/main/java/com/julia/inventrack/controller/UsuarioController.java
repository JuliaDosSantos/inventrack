package com.julia.inventrack.controller;

import com.julia.inventrack.model.Produto;
import com.julia.inventrack.model.SucessResponse;
import com.julia.inventrack.model.Usuario;
import com.julia.inventrack.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/create")
    public SucessResponse criarUsuario(@RequestBody Usuario usuario) throws Exception {
        usuarioService.salvarUsuario(usuario);
        return SucessResponse.build("Usuário cadastrado com sucesso");
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) throws Exception {
        return usuarioService.login(usuario);
    }

}
