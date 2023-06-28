package com.project.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.project.hospital.model.Especialidad;
import com.project.hospital.service.EspecialidadService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EspecialidadController {

    @Autowired
    private EspecialidadService service;

    @RequestMapping("/add-especialidad")
    public String addEspecialidad(HttpServletRequest request) {
        return "admin/especialidad/add";
    }

    @PostMapping("/add-especialidad")
    public String addEspecialidad(@ModelAttribute Especialidad especialidad, BindingResult bindingResult,
            HttpServletRequest request) {
        try {
            if (service.save(especialidad) != null) {
                request.setAttribute("success", "Especialidad registrado");
            } else {
                request.setAttribute("error", "No se pudo registrar la especialidad");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }

        return "admin/especialidad/add";
    }

    @RequestMapping("/edit-especialidad")
    public String editEspecialidad(@RequestParam int id, HttpServletRequest request) {
        request.setAttribute("especialidad", service.find(id));
        return "admin/especialidad/edit";
    }

    @PostMapping("/edit-especialidad")
    public String editEspecialidad(@ModelAttribute Especialidad especialidad, BindingResult bindingResult,
            HttpServletRequest request) {
        try {
            if (service.save(especialidad) != null) {
                request.setAttribute("success", "Especialidad actualizado");
            } else {
                request.setAttribute("error", "No se pudo actualizar la especialidad");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }

        return "admin/especialidad/edit";
    }

    @RequestMapping("/delete-especialidad")
    public String deleteEspecialidad(@RequestParam int id, HttpServletRequest request) {
        try {
            if (service.delete(id)) {
                request.setAttribute("success", "Especialidad eliminada");
            } else {
                request.setAttribute("error", "No se pudo eliminar la especialidad");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }

        request.setAttribute("especialidades", service.list());
        return "admin/especialidad/list";
    }

    @RequestMapping("/especialidades")
    public String listEspecialidades(HttpServletRequest request) {
        request.setAttribute("especialidades", service.list());
        return "admin/especialidad/list";
    }
}
