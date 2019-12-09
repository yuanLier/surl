package com.demo.demosurl.demosurl.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author yuanyiwen
 * @create 2019-12-06 21:04
 * @description
 */
@Entity
@Data
public class TranslationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 真实url（长链）
     */
    private String url;

    /**
     * 转换url（短链）
     */
    private String shortUrl;

}
