package study.platform.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import study.platform.demo.POJO.user;

public interface userdao extends JpaRepository <user,Integer>{


    user findByEmailId (@Param("email") String email);

}
