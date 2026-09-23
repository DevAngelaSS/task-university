package com.taskuniversity.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.taskuniversity.app.service.TareaService;

@Controller
public class DashboardController {

    private final TareaService tareaService;

    public DashboardController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping("/dashboard")
    public String mostrarDashboard(Model modelo) {
        modelo.addAttribute("totalTareas", tareaService.contarTotal());
        modelo.addAttribute("tareasCompletadas", tareaService.contarCompletadas());
        modelo.addAttribute("tareasPendientes", tareaService.contarPendientes());
        return "dashboard/dashboard";
    }

}
