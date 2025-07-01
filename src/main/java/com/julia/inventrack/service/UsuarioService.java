package com.julia.inventrack.service;

import com.julia.inventrack.model.Produto;
import com.julia.inventrack.model.Usuario;
import com.julia.inventrack.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    public void salvarUsuario(Usuario usuario) throws Exception {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(usuario.getEmail());
        if (optionalUsuario.isPresent()) {
            throw new Exception("E-mail já cadastrado");
        } else {
            usuarioRepository.save(usuario);
        }
    }

    public Usuario login(Usuario usuario) throws Exception {
        System.out.println("Entrou no service abaixo parametros");
        System.out.println(usuario.getEmail());
        System.out.println(usuario.getSenha());

        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(usuario.getEmail());
        if (optionalUsuario.isPresent()) {
            Usuario usuario1 = optionalUsuario.get();
            if (usuario.getSenha().equals(usuario1.getSenha())) {
                return usuario1;
            } else {
                throw new Exception("Senha incorreta");
            }
        }

        throw new Exception("Usuário não cadastrado");
    }

}
