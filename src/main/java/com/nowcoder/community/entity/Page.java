package com.nowcoder.community.entity;
//封装分页相关的信息

public class Page {
    //前两个是页面传给我的
    //当前页
    private int current = 1;

    //一页显示数据上限
    private int limit = 10;

    //后两个是自己设置返回给页面，页面需要用到的

    //数据总数（用来计算总页数）
    private int rows;

    //查询路径（用于分页链接）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current >= 1){
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        //limit有限制
        if(limit >= 1 && limit <= 100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows >= 0){
            this.rows = rows;
        }

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     * return
     */
    public int getOffset(){
        //current * limit - limit
        return (current - 1) * limit;
    }


    /**
     * 获取总页数
     * return
     */
    public int getTotal(){
        if(rows % limit == 0){
            return rows / limit;
        }
        return rows / limit + 1;
    }


    /**
     *获取起始页码
     */
    public int getFrom(){
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    //获取末尾页码
    public int getTo(){
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }





}

