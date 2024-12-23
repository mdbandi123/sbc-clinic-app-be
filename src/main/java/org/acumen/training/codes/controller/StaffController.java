package org.acumen.training.codes.controller;

import java.util.List;

import org.acumen.training.codes.model.Staff;
import org.acumen.training.codes.service.StaffService;
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
@RequestMapping("/staff")
@CrossOrigin(
	    origins = "http://localhost:5173",
	    allowedHeaders = "*",
	    methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE},
	    allowCredentials = "true"
	)
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@PostMapping("insert")
	public boolean insertStaff(@RequestBody Staff staff){
		return staffService.insertStaff(staff);
	}
	
	@PatchMapping("/update/{id}")
	public boolean updateStaff(@PathVariable Integer id, @RequestBody Staff staff) {
		return staffService.updateStaff(id, staff);
	}
	
	@GetMapping("/details/list/all")
	public List<Staff> getAllStaff(){
		return staffService.getAllStaff();
	}
	
	@GetMapping("/details/id/{id}")
	public List<Staff> getStaffById(@PathVariable Integer id) {
		return staffService.getStaffById(id);
	}

	@GetMapping("/details/icno/{icno}")
	public List<Staff> getStaffByIcNo(@PathVariable String icno) {
		return staffService.getStaffByIcNo(icno);
	}


	@GetMapping("/details/name/{name}")
	public List<Staff> getStaffByName(@PathVariable String name) {
		return staffService.getStaffByName(name);
	}
}
