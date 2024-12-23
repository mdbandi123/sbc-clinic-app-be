package org.acumen.training.codes.controller;

import java.util.List;

import org.acumen.training.codes.model.Appointment;
import org.acumen.training.codes.model.dto.AppointmentPatientDTO;
import org.acumen.training.codes.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(
	    origins = "http://localhost:5173",
	    allowedHeaders = "*",
	    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE},
	    allowCredentials = "true"
	)
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;
	
	@PostMapping("/insert")
	public boolean insertAppointment(@RequestBody Appointment appointment) {
		return appointmentService.insertAppointment(appointment);
	}
	
	@GetMapping("/details/id/{id}")
	public List<AppointmentPatientDTO> getAppointmentById(@PathVariable Integer id) {
		return appointmentService.getAppointmentById(id);
	}
	
	@GetMapping("/details/name/{name}")
	public List<AppointmentPatientDTO> getAppointmentsByName(@PathVariable String name){
		return appointmentService.getAppointmentsByName(name);
	}
	
	@GetMapping("/details/icno/{icno}")
	public List<AppointmentPatientDTO> getAppointmentsByIcNo(@PathVariable String icno){
		return appointmentService.getAppointmentByIcNo(icno);
	}
	
	@GetMapping("/details/list/all")
	public List<AppointmentPatientDTO> getAllAppointments(){
		return appointmentService.getAllAppointments();
	}
	
	@PatchMapping("/update/arrival/{id}")
	public boolean updateAppointmentArrivalStatus(@PathVariable Integer id, @RequestBody Appointment appointment) {
		return appointmentService.updateAppointmentArrivalStatus(id, appointment);
	}
	
	@PatchMapping("/update/confirmation/{id}")
	public boolean updateAppointmentConfirmationStatus(@PathVariable Integer id, @RequestBody Appointment appointment) {
		return appointmentService.updateAppointmentConfirmationStatus(id, appointment);
	}
}
