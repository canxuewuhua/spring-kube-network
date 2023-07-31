package com.huolieniao.service;

import com.huolieniao.annotation.ApiAuth;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

@Component
@Aspect
@ComponentScan
@EnableAspectJAutoProxy
@Slf4j
public class ApiAuthAop {

    @Pointcut("execution(* com.huolieniao..controller..*.*(..))")
    public void api() {
    }


    @Around(value = "api()")
    public Object isAccessMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        ApiAuth apiAuth = targetMethod.getDeclaredAnnotation(ApiAuth.class);
        if (apiAuth == null) {
            System.out.println("没有加ApiAuth注解 请检查");
            return joinPoint.proceed();
        }
        String apiAuthType = apiAuth.value();// 检查验签类型
        if ("XMJR".equals(apiAuthType)){
            System.out.println("XMJR的签名验证");
//            return "签名验证通过";
        }
        // 此处就是还用原方法的执行结果进行返回
        Object result = joinPoint.proceed(joinPoint.getArgs());
        return result;
    }
}
