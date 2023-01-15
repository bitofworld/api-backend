package com.api.apiinterface;

import com.api.sdk.client.ApiClient;
import com.api.sdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {

    @Resource
    private ApiClient ApiClient;

    @Test
    void contextLoads() {
        // 这个方法没有签名认证参数, 会报403
        System.out.println(ApiClient.getNameByGet("api"));

        // 这个方法在请求头添加了签名认证参数, ok
        User user = new User();
        user.setUsername("liapi");
        String usernameByPost = ApiClient.getUsernameByPost(user);
        System.out.println(usernameByPost);
    }

}
