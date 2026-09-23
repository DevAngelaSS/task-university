package com.taskuniversity.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.taskuniversity.app.model.Tarea;
import com.taskuniversity.app.repository.TareaRepository;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public Tarea obtenerTarea(Long id) {
        return tareaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tarea no encontrada"));
    }

    public Tarea registrarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Tarea editarTarea(Long id, Tarea datosTarea) {
        Tarea tarea = obtenerTarea(id);
        tarea.setTitulo(datosTarea.getTitulo());
        tarea.setDescripcion(datosTarea.getDescripcion());
        return tareaRepository.save(tarea);
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    public Tarea marcarCompletada(Long id) {
        Tarea tarea = obtenerTarea(id);
        tarea.setCompletada(!tarea.isCompletada());
        return tareaRepository.save(tarea);
    }

    public long contarTotal() {
        return tareaRepository.count();
    }

    public long contarCompletadas() {
        return tareaRepository.countByCompletada(true);
    }

    public long contarPendientes() {
        return tareaRepository.countByCompletada(false);
    }

}
