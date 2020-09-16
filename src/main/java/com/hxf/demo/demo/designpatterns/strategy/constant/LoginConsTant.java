package com.hxf.demo.demo.designpatterns.strategy.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * <p>
 * LoginConsTant
 * </p>
 *
 * @author hechengxi@iqingka.com
 * @date 2020年04月18日 10:44
 */
public interface LoginConsTant {

    /**
     * 登录类型
     */
    @Getter
    @AllArgsConstructor
    enum TypeEnum {
        WE_CHAT(1, "微信", "loginWeChatServiceImpl"),

        WEI_BO(2, "微博", "loginWeiBoServiceImpl");

        private Integer value;

        private String name;

        private String className;

        public static TypeEnum getInstance(Integer type) {
            if (null == type) {
                return null;
            }
            for (TypeEnum typeEnum : TypeEnum.values()){
                if(Objects.deepEquals(typeEnum.getValue(), type)){
                    return typeEnum;
                }
            }
            return null;
        }

    }
}
