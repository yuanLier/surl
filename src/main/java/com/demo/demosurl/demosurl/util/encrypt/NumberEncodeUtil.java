package com.demo.demosurl.demosurl.util.encrypt;

/**
 * @author yuanyiwen
 * @create 2019-12-07 22:02
 * @description id混淆工具类
 */
public abstract class NumberEncodeUtil {

    /**
     * 对id进行混淆
     * @param id
     * @return
     */
    public static Long encryptId(Long id) {
        Long sid = (id & 0xff000000);
        sid += (id & 0x0000ff00) << 8;
        sid += (id & 0x00ff0000) >> 8;
        sid += (id & 0x0000000f) << 4;
        sid += (id & 0x000000f0) >> 4;
        sid ^= 11184810;
        return sid;
    }

    /**
     * 对混淆的id进行还原
     * @param sid
     * @return
     */
    public static Long decodeId(Long sid) {
        sid ^= 11184810;
        Long id = (sid & 0xff000000);
        id += (sid & 0x00ff0000) >> 8;
        id += (sid & 0x0000ff00) << 8;
        id += (sid & 0x000000f0) >> 4;
        id += (sid & 0x0000000f) << 4;
        return id;
    }
}
