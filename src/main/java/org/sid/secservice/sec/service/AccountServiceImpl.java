package org.sid.secservice.sec.service;

import org.sid.secservice.sec.entities.AppRole;
import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.repo.AppRoleRepo;
import org.sid.secservice.sec.repo.AppUserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private AppUserRepo appUserRepo;
    private AppRoleRepo appRoleRepo;
    private PasswordEncoder passwordEncoder;
    public AccountServiceImpl(AppUserRepo appUserRepo, AppRoleRepo appRoleRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.appRoleRepo = appRoleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public AppUser addNewUser(AppUser appUser) {
        String pw=appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepo.save(appUser);
    }
    public AppRole addNewRole(AppRole appRole) { return appRoleRepo.save(appRole); }
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser= appUserRepo.findByUsername(username);
        AppRole appRole =appRoleRepo.findByRoleName(rolename);
        appUser.getAppRoles().add(appRole);
    }
    public AppUser loadUserByUsername(String username) {
        return appUserRepo.findByUsername(username);
    }
    public List<AppUser> listUsers() {
        return appUserRepo.findAll();
    }
}
