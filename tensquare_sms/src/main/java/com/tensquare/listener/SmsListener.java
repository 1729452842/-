package com.tensquare.listener;

import com.tensquare.utils.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @Value("${aliyun.sms.template_code}")
    private String template_code;

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;

    @RabbitHandler
    public void executeSms(Map<String, String> map)  {
        String moblie = map.get("mobile");
        String checkCode = map.get("checkCode");
        smsUtil.sendSms(moblie,sign_name,template_code,"{\"checkCode\":\""+ checkCode +"\"}");
        System.out.println("手机号："+ map.get("mobile"));
        System.out.println("验证码："+ map.get("checkCode"));
    }
}
