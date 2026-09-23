package com.taskuniversity.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taskuniversity.app.model.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

    long countByCompletada(boolean completada);

}
