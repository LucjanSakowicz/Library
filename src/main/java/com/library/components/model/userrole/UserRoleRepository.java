package com.library.components.model.userrole;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole,Long>{

	Optional<UserRole> findByUserRoleName(String userRoleName);

}
