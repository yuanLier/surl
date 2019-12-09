package com.demo.demosurl.demosurl.util.convertion;

import com.demo.demosurl.demosurl.model.entity.TranslationEntity;
import com.demo.demosurl.demosurl.model.vo.TranlationVo;

/**
 * @author yuanyiwen
 * @create 2019-12-08 16:43
 * @description
 */
public abstract class EntityVoUtil {

    public static TranlationVo convertEntityToVo(TranslationEntity translationEntity) {
        TranlationVo tranlationVo = new TranlationVo();
        tranlationVo.setUrl(translationEntity.getUrl());
        tranlationVo.setShortUrl(translationEntity.getShortUrl());
        return tranlationVo;
    }
}
