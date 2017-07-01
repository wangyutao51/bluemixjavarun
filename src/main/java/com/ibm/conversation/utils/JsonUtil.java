/**
 *JsonUtil.java
 * 
 * 2017年6月26日 下午10:40:10
 * 文件描述：
 */
package com.ibm.conversation.utils;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * 
 * @author WangYuTao
 */
public class JsonUtil
{
	 /**
     * 将json转化成map
     * @param jsonStr
     * @return
     */
    public static Map<String, Object>   convertJsonStrToMap(String jsonStr){
        
        Map<String, Object> map = JSON.parseObject(
                jsonStr,new TypeReference<Map<String, Object>>(){} );
        
        return map;
    }
}
