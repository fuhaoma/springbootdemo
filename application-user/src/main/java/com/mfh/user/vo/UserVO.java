package com.mfh.user.vo;

import com.mfh.entity.User;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
public class UserVO implements Serializable {

    private static final long serialVersionUID = -7532294320898474112L;
    private Integer id;
    private String name;
    private Integer age;
    private Boolean isEnabled=false;
    private Date createDate;
    private Date modifyDate;

    public static UserVO convert2VO(User entity) {
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }
}
