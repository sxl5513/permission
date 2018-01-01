package com.anber.controller;

import com.anber.exception.PermissionException;
import com.anber.param.TestVo;
import com.anber.util.BeanValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public Object hello() {
        log.info("hello");
        throw new RuntimeException("test exception");
//         return "hello, permission";
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public Object validate(TestVo vo) {
        log.info("validate");
        Map<String, String> map = BeanValidator.validateObject(vo);
        if (MapUtils.isNotEmpty(map)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                log.info("{}->{}", entry.getKey(), entry.getValue());
            }
        }
//        throw new RuntimeException("test validate");
         return "hello, permission";
    }
}
