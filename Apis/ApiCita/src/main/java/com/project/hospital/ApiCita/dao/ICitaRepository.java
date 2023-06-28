package com.project.hospital.ApiCita.dao;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.project.hospital.ApiCita.entity.Cita;

public interface ICitaRepository extends JpaRepository<Cita, Integer> {

	@Query(value = "SELECT c FROM Cita c WHERE c.usuario_id = :usuario_id ORDER BY c.fecha")
	public List<Cita> listByUsuario(@Param("usuario_id") int usuario_id);

	@Query(value = "SELECT c FROM Cita c ORDER BY c.fecha")
	public List<Cita> listOrdered();
	
	@Query(value = "SELECT c FROM Cita c WHERE c.fecha BETWEEN :fecha_inicio AND :fecha_fin ORDER BY c.fecha")
	public List<Cita> listByDateOrdered(Date fecha_inicio, Date fecha_fin);
}
