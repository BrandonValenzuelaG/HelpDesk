package com.valguz.HelpDesk.repository;

import com.valguz.HelpDesk.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
