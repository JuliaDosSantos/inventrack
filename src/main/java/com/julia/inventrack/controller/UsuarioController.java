package com.julia.inventrack.controller;

import com.julia.inventrack.model.Produto;
import com.julia.inventrack.model.SucessResponse;
import com.julia.inventrack.model.Usuario;
import com.julia.inventrack.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/create")
    public SucessResponse criarUsuario(@RequestBody Usuario usuario) throws Exception {
        usuarioService.salvarUsuario(usuario);
        return SucessResponse.build("Usuário cadastrado com sucesso");
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario) throws Exception {
        return usuarioService.login(usuario);
    }

}
