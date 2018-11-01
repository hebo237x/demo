package com.hebo.java.genericity;

/**
 * @author bo.he@ttpai.cn
 * @date 2018/9/30
 */
public interface IPay<T> {

    public T createOrder(Order order);
}
