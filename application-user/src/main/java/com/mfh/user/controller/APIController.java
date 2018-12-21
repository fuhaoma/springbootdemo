package com.mfh.user.controller;

import com.mfh.core.base.BaseController;
import com.mfh.entity.User;
import com.mfh.service.UserService;
import com.mfh.user.vo.UserVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mfh")
public class APIController extends BaseController {
    @Resource
    private UserService service;

    @RequestMapping("/user")
    public ResponseEntity getVO() {
        User user = service.getUser(1);
        UserVO vo = UserVO.convert2VO(user);
        return ok(vo);
    }
}
