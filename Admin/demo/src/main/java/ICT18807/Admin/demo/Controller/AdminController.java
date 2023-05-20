package ICT18807.Admin.demo.Controller;

import ICT18807.Admin.demo.Entity.Admin;
import ICT18807.Admin.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping
    // Create a new admin
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @GetMapping("/{id}")
    // Get admin by ID
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @GetMapping
    // Get all admins
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PutMapping("/{id}")
    // Update an existing admin
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        admin.setId(id);
        return adminService.updateAdmin(admin);
    }

    @DeleteMapping("/{id}")
    // Delete an admin
    public void deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }
}
