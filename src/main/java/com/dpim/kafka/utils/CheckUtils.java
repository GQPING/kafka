package com.dpim.kafka.utils;

/**
 * 核验查询参数工具类
 * @author cxw
 * @date 2021/12/27
 */
public class CheckUtils {

    /**
     * 核查查询参数中含有%、_等通配符的情况
     *
     * @param searchValue 搜索文本
     * @return String 添加过转义字符的文本内容
     * @author cxw
     * @date 2021/12/27
     */
    public static String searchValueCheck(String searchValue){
        if (StringUtils.isNotEmpty(searchValue)) {
            if(searchValue.contains("%")) {
                //所有"%"前添加"\"字符，使用字符串替换方法，注意：”\"需要转义
                searchValue = searchValue.replaceAll("%", "\\\\%");
            }
            if(searchValue.contains("_")) {
                //所有"_"前添加"\"字符，使用字符串替换方法，注意：”\"需要转义
                searchValue = searchValue.replaceAll("_", "\\\\_");
            }
        }
        return searchValue;
    }
}
