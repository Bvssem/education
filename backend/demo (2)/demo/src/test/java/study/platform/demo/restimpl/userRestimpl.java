package study.platform.demo.restimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import study.platform.demo.rest.userRest ;
import study.platform.demo.service.userService;
import study.platform.demo.utils.studyutils;

import java.util.Map;

@RestController
public class userRestimpl implements userRest {
    @Autowired
    userService userService ;
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try{
            return userService.signUP(requestMap);

        } catch (Exception ex){
            ex.printStackTrace();
        }
        return studyutils.getResponseEntity(studyutils.SOMETHING_WENT_WRONG,HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
