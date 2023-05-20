package ICT18807Assignment2.demo.Repository;

import ICT18807Assignment2.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
