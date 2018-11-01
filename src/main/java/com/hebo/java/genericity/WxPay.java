package com.hebo.java.genericity;

/**
 * @author bo.he@ttpai.cn
 * @date 2018/9/30
 */
public class WxPay implements IPay<WxConfig> {

    @Override
    public WxConfig createOrder(Order order) {
        return null;
    }
}
