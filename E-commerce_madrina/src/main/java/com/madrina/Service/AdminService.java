package com.madrina.Service;

import java.util.List;

import com.madrina.exception.AdminException;
import com.madrina.model.Admin;



public interface AdminService {
	
	Admin addAdmin(Admin admin) throws AdminException;
	 
	 Admin viewAdmin(Integer adminid) throws AdminException;
	 
	 List<Admin> viewAllAdmin() throws AdminException;
	 
	 Admin updateAdmin(Admin admin) throws AdminException;
	 
	 Admin removeAdmin(Integer adminid) throws AdminException;

}
