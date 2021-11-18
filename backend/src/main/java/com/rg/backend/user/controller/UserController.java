package com.rg.backend.user.controller;


import com.alibaba.fastjson.JSON;
import com.rg.backend.user.entity.User;
import com.rg.backend.user.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.rg.backend.util.Constant.DEVELOP_ORIGIN;
import static com.rg.backend.util.Constant.PRODUCE_ORIGIN;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Byron Ji
 * @since 2021-11-18
 */
@Api(value = "用户管理接口",tags = "用户管理接口说明")
@CrossOrigin(origins={DEVELOP_ORIGIN, PRODUCE_ORIGIN}, allowCredentials="true")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "登录验证", notes = "账户密码必须对应")
    @RequestMapping(value="/loginCheck",method = RequestMethod.POST)
    public String loginCheck(String account,String password){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            User user=userService.loginCheck(account,password);
            if(user!=null){
                map.put("status","200");
                map.put("data",user);
            }
            else {
                map.put("status","500");
                map.put("errorMsg","Fail");
            }
        }
        catch(Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

    @ApiOperation(value = "添加用户", notes = "用户名不允许重复")
    @RequestMapping(value="/regAdd",method = RequestMethod.POST)
    public String regAdd(String account,String password){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            int flag=userService.regAdd(account,password);
            if(flag==1){
                map.put("status","200");
                map.put("data","Success");
            }
            else if(flag==0){
                map.put("status","200");
                map.put("errorMsg","Fail,userName has existed");
            }
        }
        catch(Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

    @ApiOperation(value = "获得某个用户", notes = "根据用户名")
    @RequestMapping(value="/getUser",method = RequestMethod.POST)
    public String getUser(String account){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            User user=userService.getUser(account);
            map.put("status","200");
            if(user!=null){
                map.put("data",user);
            }
            else {
                map.put("errorMsg","Fail,can't find user "+account);
            }
        }
        catch(Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }

    @ApiOperation(value = "修改密码", notes = "根据旧密码新密码修改密码")
    @RequestMapping(value="/resetPass",method = RequestMethod.POST)
    public String resetPass(String account,String oldPassword, String newPassword){
        Map<String,Object> map=new HashMap<String,Object>();
        try{
            int flag=userService.resetPass(account,oldPassword,newPassword);
            if(flag==1){
                map.put("status","200");
                map.put("msg","Success");
            }
            else if(flag==0){
                map.put("status","200");
                map.put("errorMsg","Fail,error password");
            }
        }
        catch(Exception ex){
            map.put("status","500");
            map.put("errorMsg","Error:"+ex.getMessage());
        }
        return JSON.toJSONString(map);
    }
}
