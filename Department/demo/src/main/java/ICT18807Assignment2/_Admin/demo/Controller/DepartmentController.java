package ICT18807Assignment2._Admin.demo.Controller;

import ICT18807Assignment2._Admin.demo.Entity.Department;
import ICT18807Assignment2._Admin.demo.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    // Create a new department
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @GetMapping("/{id}")
    // Get department by ID
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping
    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PutMapping("/{id}")
    // Update an existing department
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        department.setId(id);
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/{id}")
    // Delete a department
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
