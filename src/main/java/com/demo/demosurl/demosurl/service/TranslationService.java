package com.demo.demosurl.demosurl.service;

import com.demo.demosurl.demosurl.model.vo.TranlationVo;

/**
 * @author yuanyiwen
 * @create 2019-12-06 21:11
 * @description
 */
public interface TranslationService {

    /**
     * 根据真实url获取短url时，返回转换实体
     * @param url
     * @return
     */
    TranlationVo getShortUrlByUrl(String url);

    /**
     * 根据短url获取真实url时，返回转换实体
     * @param shortUrl
     * @return
     */
    TranlationVo getUrlByShortUrl(String shortUrl);

}
