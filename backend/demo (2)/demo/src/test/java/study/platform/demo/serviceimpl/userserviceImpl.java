package study.platform.demo.serviceimpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import study.platform.demo.POJO.user;
import study.platform.demo.constent.studyconstant;
import study.platform.demo.dao.userdao;
import study.platform.demo.service.userService ;
import study.platform.demo.utils.studyutils;

import java.util.Map;
import java.util.Objects;

@Slf4j
@Service
public class userserviceImpl implements userService {
    @Autowired
    userdao UserDao;
    @Override
    public ResponseEntity<String> signUP(Map<String, String> requestMap) {
        log.info("Inside singnUP{}", requestMap);
        try {
            if (validatesignUPMap(requestMap)) {
                user user = UserDao.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(user)) {
                    UserDao.save(getUserFromMap(requestMap));
                    return studyutils.getResponseEntity("Successfully Registred.", HttpStatus.OK);

                } else {
                    return studyutils.getResponseEntity("Email already exists", HttpStatus.BAD_REQUEST);
                }

            } else {
                return studyutils.getResponseEntity(studyconstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return studyutils.getResponseEntity(studyconstant.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);


    }
    private boolean validatesignUPMap(Map<String,String> requestMap){
       if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("password")) {
           return true;
       }
        {
            return false;
        }
    }
    private user getUserFromMap(Map<String,String> requestMap){
        user User = new user ();
       User.setName(requestMap.get("name"));
       User.setContactNumber(requestMap.get("contactNumber"));
       User.setEmail(requestMap.get("email"));
;       User.setPassword(requestMap.get("password"));
       User.setStatus("false");
        User.setRole("user");
        return User;

    }
}
