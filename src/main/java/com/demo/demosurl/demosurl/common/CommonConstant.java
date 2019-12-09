package com.demo.demosurl.demosurl.common;

/**
 * @author yuanyiwen
 * @create 2019-12-07 22:13
 * @description 保存项目中用到的常量
 */
public interface CommonConstant {

    /**
     * 默认生成的短链接后缀长度
     */
    Integer LENGTH_OF_SHORT_URL = 4;


    /**
     * 默认生成的短链接前缀
     */
    String PRIFIX_OF_SHORT_URL = "http://localhost:8090/";


    /**
     * 若输入的短链接不存在，默认跳转的页面
     */
    String DEFAULT_URL = "http://localhost:8090/default";
}
