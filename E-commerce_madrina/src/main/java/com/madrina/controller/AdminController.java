package com.madrina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.madrina.Service.AdminService;
import com.madrina.exception.AdminException;
import com.madrina.model.Admin;


@RestController
public class AdminController {
	
	@Autowired
	private AdminService AService;
	
	
	@PostMapping("/admins")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws AdminException {

		Admin resisteredAdmin = AService.addAdmin(admin);

		return new ResponseEntity<Admin>(resisteredAdmin, HttpStatus.ACCEPTED);

	}

	@GetMapping("/admins/{id}")
	public ResponseEntity<Admin> viewAdmin(@PathVariable("id") Integer adminid) throws AdminException {

		Admin resisteredAdmin = AService.viewAdmin(adminid);

		return new ResponseEntity<Admin>(resisteredAdmin, HttpStatus.ACCEPTED);

	}

	@GetMapping("/getadmins")
	ResponseEntity<List<Admin>> viewAllAdmin() throws AdminException {

		List<Admin> allAdmins = AService.viewAllAdmin();

		return new ResponseEntity<List<Admin>>(allAdmins, HttpStatus.ACCEPTED);

	}

	@PutMapping("/admins")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin) throws AdminException {

		Admin updatedAdmin = AService.updateAdmin(admin);

		return new ResponseEntity<Admin>(updatedAdmin, HttpStatus.OK);

	}

	@DeleteMapping("/admins/{id}")
	public ResponseEntity<Admin>  removeAdmin(@PathVariable("id") Integer adminid) throws AdminException{
		
		Admin removedAdmin = AService.removeAdmin(adminid);

		return new ResponseEntity<Admin>(removedAdmin, HttpStatus.ACCEPTED);

}
	
}
