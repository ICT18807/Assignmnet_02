package ICT18807Assignment2.demo.Service;

import ICT18807Assignment2.demo.Entity.Employee;
import ICT18807Assignment2.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    // Create an employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Retrieve an employee by ID
    @CircuitBreaker(name = "getEmployee", fallbackMethod = "getEmployeeFallback")
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Retrieve all employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Update an employee
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Delete an employee by ID
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Fallback method for getEmployeeById
    public Employee getEmployeeFallback(Long id, Throwable throwable) {
        // Fallback logic to handle failures
        // Return a default Employee or an appropriate fallback response
        Employee fallbackEmployee = new Employee();
        fallbackEmployee.setId(id);
        fallbackEmployee.setName("Fallback Employee");

        return fallbackEmployee;
    }
}
