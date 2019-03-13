package com.bwie.shuaxin.bean;

/**
 * @Author：余振华
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/13 19:23
 * @Description：描述信息
 */
public class One {
    private String cover;
    private String desc;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "One{" +
                "cover='" + cover + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
