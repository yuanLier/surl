package com.demo.demosurl.demosurl.dao;

import com.demo.demosurl.demosurl.model.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yuanyiwen
 * @create 2019-12-06 21:10
 * @description
 */
@Repository
public interface TranslationDto extends JpaRepository<TranslationEntity, Long> {

    /**
     * 根据url获取对应的转换实体
     * @param url
     * @return
     */
    TranslationEntity findByUrl(String url);


    /**
     * 根据shortUrl获取对应的转换实体
     * @param shortUrl
     * @return
     */
    TranslationEntity findByShortUrl(String shortUrl);


    /**
     * 获取已存储的URL总数，则该数值+1即为短链生成时所使用的那个最新id
     * @return
     */
    long count();
}
