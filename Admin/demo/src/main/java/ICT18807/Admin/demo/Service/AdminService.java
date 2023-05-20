package ICT18807.Admin.demo.Service;

import ICT18807.Admin.demo.Entity.Admin;
import ICT18807.Admin.demo.Repository.AdminRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    // Create an admin
    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Retrieve an admin by ID
    @CircuitBreaker(name = "getAdmin", fallbackMethod = "getAdminFallback")
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }

    // Retrieve all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Update an admin
    public Admin updateAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Delete an admin by ID
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }

    // Fallback method for getAdminById
    public Admin getAdminFallback(Long id, Throwable throwable) {
        // Fallback logic to handle failures
        // Return a default Admin or an appropriate fallback response
        Admin fallbackAdmin = new Admin();
        fallbackAdmin.setId(id);
        fallbackAdmin.setName("Fallback Admin");

        return fallbackAdmin;
    }
}
