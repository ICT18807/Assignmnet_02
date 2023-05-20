package ICT18807Assignment2._Admin.demo.Repository;

import ICT18807Assignment2._Admin.demo.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
