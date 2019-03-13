package com.bwie.shuaxin.bean;

import java.util.ArrayList;

/**
 * @Author：余振华
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/13 19:25
 * @Description：描述信息
 */
public class Two {
    private One aladdin;

    public One getAladdin() {
        return aladdin;
    }

    public void setAladdin(One aladdin) {
        this.aladdin = aladdin;
    }

    @Override
    public String toString() {
        return "Two{" +
                "aladdin=" + aladdin +
                '}';
    }
}
