package com.jk.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.service.TestService;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String say(String something) {
        return "小明说的"+something;
    }
}
