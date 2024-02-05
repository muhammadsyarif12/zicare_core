package ms.gamehouse.zicareTest.repository;

import ms.gamehouse.zicareTest.models.EnumRole;
import ms.gamehouse.zicareTest.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(EnumRole name);
}
