package com.taskuniversity.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.taskuniversity.app.model.Usuario;
import com.taskuniversity.app.service.UsuarioService;

import jakarta.validation.Valid;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public String listarUsuarios(Model modelo) {
        modelo.addAttribute("usuarios", usuarioService.listarUsuarios());
        modelo.addAttribute("usuario", new Usuario());
        return "usuarios/lista";
    }

    @PostMapping("/usuarios")
    public String registrarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario,
                                    BindingResult resultado, Model modelo) {
        if (resultado.hasErrors()) {
            modelo.addAttribute("usuarios", usuarioService.listarUsuarios());
            return "usuarios/lista";
        }
        usuarioService.registrarUsuario(usuario);
        return "redirect:/usuarios";
    }

}
