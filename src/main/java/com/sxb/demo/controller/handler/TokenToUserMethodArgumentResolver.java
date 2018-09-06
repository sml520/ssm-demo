package com.sxb.demo.controller.handler;

import com.sxb.demo.controller.annotation.TokenToUser;
import com.sxb.demo.entity.AdminUser;
import com.sxb.demo.service.AdminUserService;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;

/**
 * Created by 张元亮 on 2018/9/6.
 * @author
 */
public class TokenToUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Resource
    private AdminUserService adminUserService;

    public TokenToUserMethodArgumentResolver() {

    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if (parameter.hasParameterAnnotation(TokenToUser.class)) {
            return true;
        }

        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        if (methodParameter.getParameterAnnotation(TokenToUser.class) instanceof  TokenToUser) {
            AdminUser user = null;
            String token = nativeWebRequest.getHeader("token");
            if (token != null && !"".equals(token)) {
                user =adminUserService.getAdminUserByToken(token);
            }
            return user;
        }
        return null;
    }
}
