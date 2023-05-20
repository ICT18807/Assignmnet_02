package ICT18807.Admin.demo.Repository;

import ICT18807.Admin.demo.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
