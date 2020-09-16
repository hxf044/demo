package com.hxf.demo.demo.designpatterns.strategy.web;

import com.hxf.demo.demo.designpatterns.strategy.constant.LoginConsTant;
import com.hxf.demo.demo.designpatterns.strategy.context.LoginContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "活动中心管理")
public class LoginController {

    @Autowired
    private LoginContext loginContext;


    @GetMapping("/login/{type}")
    @ApiOperation(value = "分页查询活动中心列表")
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


    @PostMapping("/login1")
    @ApiOperation(value = "分页查询活动中心列表1")
    public String login(@RequestBody @Validated OfflineCouponReq req) {
        try {
            log.info("用户登录成功");
            return "ok";
        } catch (Exception e) {
        }
        return "fail";
    }

}
