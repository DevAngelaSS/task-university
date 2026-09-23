package com.taskuniversity.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskuniversity.app.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
