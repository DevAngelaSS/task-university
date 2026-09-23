package com.taskuniversity.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.taskuniversity.app.model.Tarea;
import com.taskuniversity.app.service.TareaService;

import jakarta.validation.Valid;

@Controller
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping("/tareas")
    public String listarTareas(Model modelo) {
        modelo.addAttribute("tareas", tareaService.listarTareas());
        modelo.addAttribute("tarea", new Tarea());
        return "tareas/lista";
    }

    @PostMapping("/tareas")
    public String registrarTarea(@Valid @ModelAttribute("tarea") Tarea tarea,
                                  BindingResult resultado, Model modelo) {
        if (resultado.hasErrors()) {
            modelo.addAttribute("tareas", tareaService.listarTareas());
            return "tareas/lista";
        }
        tareaService.registrarTarea(tarea);
        return "redirect:/tareas";
    }

    @GetMapping("/tareas/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("tarea", tareaService.obtenerTarea(id));
        return "tareas/formulario";
    }

    @PostMapping("/tareas/editar/{id}")
    public String editarTarea(@PathVariable Long id, @Valid @ModelAttribute("tarea") Tarea tarea,
                               BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "tareas/formulario";
        }
        tareaService.editarTarea(id, tarea);
        return "redirect:/tareas";
    }

    @GetMapping("/tareas/eliminar/{id}")
    public String eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return "redirect:/tareas";
    }

    @GetMapping("/tareas/completar/{id}")
    public String marcarCompletada(@PathVariable Long id) {
        tareaService.marcarCompletada(id);
        return "redirect:/tareas";
    }

}
