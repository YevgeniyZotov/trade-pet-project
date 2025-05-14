package kz.project1.trade.repository;

import kz.project1.trade.model.User;
import kz.project1.trade.model.enums.UserStatus;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByStatus(UserStatus status);

}
