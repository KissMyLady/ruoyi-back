package com.ruoyi.common.exception.user;

import com.ruoyi.common.exception.base.BaseException;

/**
 * 用户信息异常类
 *
 * @author ruoyi
 */
public class UserException extends BaseException {

    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        //调用BaseException类的构造函数。
        // 第一个参数"user"是传递给父类构造函数的异常类型，
        // 第二个参数code是传递给父类构造函数的错误码，
        // 第三个参数args是传递给父类构造函数的错误信息参数，
        // 第四个参数null是传递给父类构造函数的异常原因。
        super("user", code, args, null);
    }
}
