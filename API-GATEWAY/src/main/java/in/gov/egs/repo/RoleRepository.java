package in.gov.egs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.gov.egs.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
