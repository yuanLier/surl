package com.demo.demosurl.demosurl.controller;

import com.demo.demosurl.demosurl.common.CommonConstant;
import com.demo.demosurl.demosurl.model.vo.TranlationVo;
import com.demo.demosurl.demosurl.service.TranslationService;
import com.demo.demosurl.demosurl.util.response.ResponseUtil;
import com.demo.demosurl.demosurl.util.response.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author yuanyiwen
 * @create 2019-12-07 22:20
 * @description
 */
@RestController
public class TranslationController {

    @Autowired
    private TranslationService translationService;

    @PostMapping("/surl")
    public ResponseVo<TranlationVo> getShortUrlByUrl(String url) {

        TranlationVo tranlationVo = translationService.getShortUrlByUrl(url);

        if(tranlationVo == null) {
            return ResponseUtil.toFailResponseVo("请检查上传的url格式");
        }

        return ResponseUtil.toSuccessResponseVo(tranlationVo);
    }

    @GetMapping("{shortUrl}")
    public ModelAndView redirect(@PathVariable String shortUrl, ModelAndView mav){

        // 获取对应的长链接（若短链接不存在，则跳转到默认页面）
        TranlationVo tranlationVo = translationService.getUrlByShortUrl(CommonConstant.PRIFIX_OF_SHORT_URL + shortUrl);
        String url = (tranlationVo == null) ? CommonConstant.DEFAULT_URL : tranlationVo.getUrl();

        // 跳转
        mav.setViewName("redirect:" + url);

        return mav;
    }
}
