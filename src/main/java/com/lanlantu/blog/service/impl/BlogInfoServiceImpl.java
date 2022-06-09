package com.lanlantu.blog.service.impl;

import com.lanlantu.blog.service.BlogInfoService;
import com.lanlantu.blog.util.IpUtils;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Service
@Slf4j
public class BlogInfoServiceImpl implements BlogInfoService {


    @Resource
    private HttpServletRequest request;


    @Override
    public void report() {
        // 获取ip
        String ipAddress = IpUtils.getIpAddress(request);
        log.info("ip {}",ipAddress);
        // 获取访问设备
        UserAgent userAgent = IpUtils.getUserAgent(request);
        log.info("userAgent {}",userAgent);
        Browser browser = userAgent.getBrowser();
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();
        // 生成唯一用户标识
        String uuid = ipAddress + browser.getName() + operatingSystem.getName();
        String md5 = DigestUtils.md5DigestAsHex(uuid.getBytes());
    }



}
