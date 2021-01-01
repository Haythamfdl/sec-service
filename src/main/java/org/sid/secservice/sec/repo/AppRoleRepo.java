package org.sid.secservice.sec.repo;


import org.sid.secservice.sec.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepo extends JpaRepository<AppRole, Long> {
    AppRole findByRoleName(String roleName);
}
