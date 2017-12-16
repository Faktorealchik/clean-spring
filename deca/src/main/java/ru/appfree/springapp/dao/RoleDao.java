package ru.appfree.springapp.dao;

import ru.appfree.springapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
