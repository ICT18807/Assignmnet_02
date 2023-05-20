package ICT18807Assignment2._Admin.demo.Service;

import ICT18807Assignment2._Admin.demo.Entity.Department;
import ICT18807Assignment2._Admin.demo.Repository.DepartmentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    // Create a department
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Retrieve a department by ID
    @CircuitBreaker(name = "getDepartment", fallbackMethod = "getDepartmentFallback")
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    // Retrieve all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Update a department
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Delete a department by ID
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    // Fallback method for getDepartmentById
    public Department getDepartmentFallback(Long id, Throwable throwable) {
        // Fallback logic to handle failures
        // Return a default Department or an appropriate fallback response
        Department fallbackDepartment = new Department();
        fallbackDepartment.setId(id);
        fallbackDepartment.setName("Fallback Department");

        return fallbackDepartment;
    }
}
