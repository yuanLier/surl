package com.demo.demosurl.demosurl.service.impl;

import com.demo.demosurl.demosurl.common.CommonConstant;
import com.demo.demosurl.demosurl.dao.TranslationDto;
import com.demo.demosurl.demosurl.model.entity.TranslationEntity;
import com.demo.demosurl.demosurl.model.vo.TranlationVo;
import com.demo.demosurl.demosurl.service.TranslationService;
import com.demo.demosurl.demosurl.util.convertion.EntityVoUtil;
import com.demo.demosurl.demosurl.util.encrypt.NumberEncodeUtil;
import com.demo.demosurl.demosurl.util.encrypt.ScaleConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yuanyiwen
 * @create 2019-12-06 21:12
 * @description
 */
@Service
public class TranslationServiceImpl implements TranslationService {

    @Autowired
    private TranslationDto translationDto;

    @Override
    public TranlationVo getShortUrlByUrl(String url) {

        // 若不是URL格式，直接返回空
        if(!isHttpUrl(url)) {
            return null;
        }

        TranslationEntity translationEntity = translationDto.findByUrl(url);

        // 如果该实体不为空，直接返回对应的短url
        if(translationEntity != null) {
            return EntityVoUtil.convertEntityToVo(translationEntity);
        }

        // 否则，重新生成转换实体并存入数据库 todo 存入缓存
        translationEntity = new TranslationEntity();

        // 获取当前id并生成短url尾缀
        Long currentId = translationDto.count()+1;
        String shortUrlSuffix = ScaleConvertUtil.convert(NumberEncodeUtil.encryptId(currentId), CommonConstant.LENGTH_OF_SHORT_URL);

        // 短链接拼接
        String shortUrl = CommonConstant.PRIFIX_OF_SHORT_URL + shortUrlSuffix;

        translationEntity.setUrl(url);
        translationEntity.setShortUrl(shortUrl);
        translationDto.save(translationEntity);

        return EntityVoUtil.convertEntityToVo(translationEntity);
    }

    @Override
    public TranlationVo getUrlByShortUrl(String shortUrl) {
        TranslationEntity translationEntity = translationDto.findByShortUrl(shortUrl);
        if(translationEntity != null) {
            return EntityVoUtil.convertEntityToVo(translationEntity);
        }
        return null;
    }

    /**
     * 判断一个字符串是否为URL格式
     * @param url
     * @return
     */
    private boolean isHttpUrl(String url) {
        boolean isUrl = false;
        if(url.startsWith("http://") || url.startsWith("https://")) {
            isUrl = true;
        }
        return isUrl;
    }
}
