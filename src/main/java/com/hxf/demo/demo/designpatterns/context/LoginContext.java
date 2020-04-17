package com.hxf.demo.demo.designpatterns.context;

import com.hxf.demo.demo.designpatterns.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * LoginContext
 * </p>
 *
 * @author hechengxi@iqingka.com
 * @date 2020年04月17日 17:52
 */
@Slf4j
@Component
public class LoginContext {

    @Autowired
    private final Map<String, LoginService>  loginMap = new ConcurrentHashMap<>();

    public LoginContext(Map<String, LoginService> loginMap) {
        this.loginMap.clear();
        loginMap.forEach((k, v)-> this.loginMap.put(k, v));
    }


    public LoginService getLoginService(String componentName) {
        return loginMap.get(componentName);
    }

}
