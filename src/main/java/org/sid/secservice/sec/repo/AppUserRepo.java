package org.sid.secservice.sec.repo;

import org.sid.secservice.sec.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String userName);
}
