package com.hxf.demo.demo.designpatterns.web;

import com.hxf.demo.demo.designpatterns.constant.LoginConsTant;
import com.hxf.demo.demo.designpatterns.context.LoginContext;
import com.hxf.demo.demo.designpatterns.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * LoginController
 * </p>
 *
 * @author liudong@iqingka.com
 * @date 2019年12月16日 13:02
 */
@RestController
@RequestMapping("/admin/login")
@Slf4j
public class LoginController {

    @Autowired
    private LoginContext loginContext;

    /**
     * 验证用户名密码
     *
     * @param type
     * @return
     */
    @GetMapping("/login/{type}")
    public String login(@PathVariable("type") Integer type) {
        try {
            log.info("获取用户信息成功");
            LoginConsTant.TypeEnum typeEnum = LoginConsTant.TypeEnum.getInstance(type);
            if (null == typeEnum) {
                return "登录类型不对";
            }
            loginContext.getLoginService(typeEnum.getClassName()).checkUser();
            log.info("用户登录成功");
            return "ok";
        } catch (Exception e) {
            log.error("LoginController login error type={}", type, e);
        }
        return "fail";
    }


}
