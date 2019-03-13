package com.bwie.shuaxin.bean;

/**
 * @Author：余振华
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/13 19:29
 * @Description：描述信息
 */
public class Three {
    private Two data;

    @Override
    public String toString() {
        return "Three{" +
                "data=" + data +
                '}';
    }

    public Two getData() {
        return data;
    }

    public void setData(Two data) {
        this.data = data;
    }
}
