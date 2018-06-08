package com.james.demo.common.util;

import com.james.demo.common.exception.BusinessException;

/**
 * Created by James_hu on 2018/6/6
 **/
public class BSUtil {
    public static void isTrue(boolean expression, String error){
        if(!expression) {
            throw new BusinessException(error);
        }
    }
}
