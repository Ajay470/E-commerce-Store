package com.madrina.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.madrina.exception.AdminException;
import com.madrina.model.Admin;
import com.madrina.repository.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{
	
	private AdminRepo Arepo; 

	@Override
	public Admin addAdmin(Admin admin) throws AdminException {
		Optional<Admin> checkExistance = Arepo.findById(admin.getId());

		if (checkExistance.isPresent())
			throw new AdminException("This admin alreday present...!");

		else

			return Arepo.save(admin);
	}

	@Override
	public Admin viewAdmin(Integer adminid) throws AdminException {
		Optional<Admin> checkExistance = Arepo.findById(adminid);

		if (checkExistance.isPresent())
			return checkExistance.get();

		else

			throw new AdminException("Admin not found...!");
	}

	@Override
	public List<Admin> viewAllAdmin() throws AdminException {
		List<Admin> allAdmins = Arepo.findAll();

		if (allAdmins.size() != 0)
			return allAdmins;
		else
			throw new AdminException("No admin found...!");
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException {
		Optional<Admin> checkExistance = Arepo.findById(admin.getId());

		if (checkExistance.isPresent())
			return Arepo.save(admin);

		else

			throw new AdminException("Invalid Admin...!");
	}

	@Override
	public Admin removeAdmin(Integer adminid) throws AdminException {
		Optional<Admin> checkExistance = Arepo.findById(adminid);

		if (checkExistance.isPresent()) {
			Arepo.delete(checkExistance.get());
		    return checkExistance.get();
		}
		else {

			throw new AdminException("Invalid Admin...!");
		
		}
	}

}
