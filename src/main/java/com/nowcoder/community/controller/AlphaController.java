package com.nowcoder.community.controller;

import com.nowcoder.community.service.Alphaservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {


    @Autowired
    private Alphaservice alphaservice;

    @RequestMapping("hello") //声明路径（浏览器请求）
    @ResponseBody//java对象转为json格式的数据,输出到页面上
    public String sayHello(){
        return "Hello spring Boot";

    }

    @RequestMapping("data")
    @ResponseBody
    public String getData(){
        return alphaservice.find();
    }

    @RequestMapping("http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ":" + value);

        }
        System.out.println(request.getParameter("code"));

        //返回响应数据
        response.setContentType("text/html;charset=utf-8");//让网页支持中文，改变响应包中的编码方式
        try ( //加小括号最后自动关闭
                PrintWriter writer = response.getWriter();)
        {

            writer.write("<hl>牛客网<hl>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //GET请求
    ///students?current=1&limit=20
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current", required = false, defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false, defaultValue = "10")int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some students";
    }

    ///student123
    @RequestMapping(path = "/student/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }


    //Post请求
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age){
        System.out.println(name);
        System.out.println(age);
        return "success";

    }


    //响应HTML数据
    @RequestMapping(path = "/techer", method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("name", "zhangsan");
        mav.addObject("age", "30");
        mav.setViewName("/demo/view");
        return mav;


    }


    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name", "北京大学");
        model.addAttribute("age", "10");
        return "/demo/view";
    }


    //响应JSON数据(异步请求)
    //JAVA对象 -> JSON字符串 -> JS对象

    @RequestMapping(path = "/emp", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getTmp(){
        Map<String, Object> tmp = new HashMap<>();
        tmp.put("name", "张三");
        tmp.put("age", 23);
        tmp.put("salary", 8000.00);
        return tmp;
    }



    @RequestMapping(path = "/emps", method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getTmps(){
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> tmp = new HashMap<>();
        tmp.put("name", "张三");
        tmp.put("age", 23);
        tmp.put("salary", 8000.00);
        list.add(tmp);

        tmp = new HashMap<>();
        tmp.put("name", "李四");
        tmp.put("age", 23);
        tmp.put("salary", 9000);
        list.add(tmp);

        tmp = new HashMap<>();
        tmp.put("name", "王伟");
        tmp.put("age", 23);
        tmp.put("salary", 1000);
        list.add(tmp);





        return list;
    }












}
