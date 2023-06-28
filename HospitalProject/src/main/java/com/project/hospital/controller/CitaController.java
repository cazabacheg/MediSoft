package com.project.hospital.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.hospital.model.Cita;
import com.project.hospital.model.Usuario;
import com.project.hospital.service.CitaService;
import com.project.hospital.service.EspecialidadService;
import com.project.hospital.utils.Utils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class CitaController {

    @Autowired
    private CitaService service;

    @Autowired
    private EspecialidadService especialidadService;

    @RequestMapping("add-cita")
    public String addCita(HttpServletRequest request) {
        request.setAttribute("especialidades", especialidadService.list());
        return "cliente/add-cita";
    }

    @PostMapping("add-cita")
    public String addCita(@ModelAttribute Cita cita, BindingResult bindingResult, HttpServletRequest request) {
        try {
            Usuario user = (Usuario) request.getSession().getAttribute("user");
            cita.setUsuario_id(user.getId());
            cita.setFecha(Utils.sdf.parse(request.getParameter("fecha")));
            cita.setEspecialidad_id(Integer.parseInt(request.getParameter("especialidad.id")));
            if (service.save(cita) != null) {
                request.setAttribute("success", "Cita registrada");
            } else {
                request.setAttribute("error", "No se pudo registrar la cita");
            }
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }

        request.setAttribute("especialidades", especialidadService.list());
        return "cliente/add-cita";
    }

    @RequestMapping("mis-citas")
    public String misCitas(HttpServletRequest request) {
        Usuario usuario = (Usuario) request.getSession().getAttribute("user");
        if (usuario != null) {
            request.setAttribute("citas", service.listByUsuario(usuario.getId()));
        }
        return "cliente/list-cita";
    }

    @RequestMapping("citas")
    public String listCitasGet(HttpServletRequest request) {
        request.setAttribute("citas", service.list(null, null));
        return "admin/cita/list";
    }

    @PostMapping("citas")
    public String listCitas(HttpServletResponse response, HttpServletRequest request) {
        String fecha_inicio = request.getParameter("fecha_inicio");
        String fecha_fin = request.getParameter("fecha_fin");

        Date dFecha_inicio = null;
        Date dFecha_fin = null;

        try {
            dFecha_inicio = Utils.sdf.parse(fecha_inicio.isEmpty() ? "1990-01-01" : fecha_inicio);
            dFecha_fin = Utils.sdf.parse(fecha_fin.isEmpty() ? "2040-01-01" : fecha_fin);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        request.setAttribute("citas", service.list(dFecha_inicio, dFecha_fin));
        request.setAttribute("fecha_inicio", fecha_inicio);
        request.setAttribute("fecha_fin", fecha_fin);
        return "admin/cita/list";
    }
}
