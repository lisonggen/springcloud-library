package common.entity;

import lombok.Data;

import java.util.Date;

/**
 * @program: springcloud-library
 * @description:
 * @author: Reagan Li
 * @create: 2020-11-15 11:17
 **/
@Data
public class User {

    private Long userId;

    private String userName;

    private String idCardType;

    private String idCardNum;

    private String phone;

    private String email;

    private String password;

    private String address;

    private Date birthday;

    private String gender;

    private String role;

    private Date createTime;

    private Date updateTime;
}
