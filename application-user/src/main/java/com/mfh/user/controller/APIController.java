package com.mfh.user.controller;

import com.mfh.core.base.BaseController;
import com.mfh.entity.User;
import com.mfh.service.UserService;
import com.mfh.user.vo.UserEntity;
import com.mfh.user.vo.UserVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/mfh")
public class APIController extends BaseController {
    @Resource
    private UserService service;

    @RequestMapping("/user")
    public ResponseEntity getVO(@RequestParam("id")Integer id) {
        User user = service.getUser(id);
        UserVO vo = UserVO.convert2VO(user);
        return ok(vo);
    }
    @GetMapping("/user/age")
    public ResponseEntity getAge() {
        List<String> ages = service.getAgeAndName();
        return ok(ages);
    }

    @PostMapping("/user")
    public ResponseEntity createUser(@RequestBody UserEntity user){
        return ok("成功");
    }
}
