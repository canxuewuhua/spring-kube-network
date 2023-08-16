package com.huolieniao.controller;

import com.huolieniao.annotation.ApiAuth;
import com.huolieniao.annotation.Gender;
import com.huolieniao.annotation.Name;
import com.huolieniao.annotation.Profile;
import com.huolieniao.domain.Addr;
import com.huolieniao.domain.Person;
import com.huolieniao.domain.SingleSwitch;
import com.huolieniao.service.DownLoadDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * 自定义注解：将注解放在一个类的某个别属性上 可以通过调用类的getDeclaredFields 动态获取到类上的所有属性 以及属性上自定义注解上的默认值 或者自定义的值
 *
 * 还有一个是可以作用在方法上，这样在调用该方法时 比如拦截controller中的某个方法 然后通过aop得到getDeclaredAnnotation 根据注解的值 处理不同的业务逻辑
 */

@RestController
@RequestMapping("kube")
@Slf4j
public class KubeController {

    @Autowired
    private DownLoadDataService downLoadDataService;


//    @Autowired
//    private ApolloConfig apolloConfig;
//
//    @GetMapping("addr")
//    public String getApolloConfig(){
//        log.info("getApolloConfig 方法 日志打印....");
//        String addr = apolloConfig.getAddr();
//        List<String> storeList = apolloConfig.getStoreList();
//        Map<String, SingleSwitch> allSwithchMap = apolloConfig.getAllSwithchMap();
//        Addr address = apolloConfig.getAddress();
//        return "addr:" + addr + "storeList: " + storeList + "allSwithchMap: "+ allSwithchMap + "address:" + address;
//    }

    @GetMapping("msg")
    public String getKubeMsg(){
        log.info("getKubeMsg 方法 日志打印....");
        return "kubeMsg";
    }

    @GetMapping("async")
    public String getAsync(){
        downLoadDataService.executeDownLoad();
        return "ok";
    }

    @ApiAuth(value = "XMJR", country = "zhongguo")
    @GetMapping("anno")
    public String getAnnotationBus(){

        Field[] declaredFields = Person.class.getDeclaredFields();
        for (Field field : declaredFields){
            // 查看方法中是否有XXX注解
            if (field.isAnnotationPresent(Name.class)){
                Name annotation = field.getAnnotation(Name.class);
                System.out.println("姓名： " + annotation.value());
            }else if (field.isAnnotationPresent(Gender.class)){
                Gender annotation = field.getAnnotation(Gender.class);
                System.out.println("性别： " + annotation.gender());
            }else if (field.isAnnotationPresent(Profile.class)){
                Profile annotation = field.getAnnotation(Profile.class);
                System.out.println("Profile===== 身高:" + annotation.height()+ " 体重：" + annotation.weight() + " 籍贯：" + annotation.address());
            }
        }
        return "this is a annotation business!!!!";
    }
}
