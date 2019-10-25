package com.ihrm.system.controller;

import com.ihrm.common.controller.BaseController;
import com.ihrm.common.entity.PageResult;
import com.ihrm.common.entity.Result;
import com.ihrm.domain.company.system.User;
import com.ihrm.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//1.解决跨域
@CrossOrigin
//2.声明restContoller
@RestController
//3.设置父路径
@RequestMapping(value="/sys")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    /**
     * 保存
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Result save(@RequestBody User user) {
        //1.设置保存的企业id
        user.setCompanyId(companyId);
        user.setCompanyName(companyName);
        //2.调用service完成保存企业
        userService.save(user);
        //3.构造返回结果
        return Result.SUCCESS();
    }

    /**
     * 查询企业的部门列表
     * 指定企业id
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Result findAll(int page, int size, @RequestParam Map map) {
        //1.获取当前的企业id
        map.put("companyId",companyId);
        //2.完成查询
        Page<User> pageUser = userService.findAll(map,page,size);
        //3.构造返回结果
        PageResult pageResult = new PageResult(pageUser.getTotalElements(),pageUser.getContent());
        return Result.SUCCESS(pageResult);
    }

    /**
     * 根据ID查询user
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id) {
        User user = userService.findById(id);
        return Result.SUCCESS(user);
    }

    /**
     * 修改User
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable(value = "id") String id, @RequestBody User user) {
        //1.设置修改的部门id
        user.setId(id);
        //2.调用service更新
        userService.update(user);
        return Result.SUCCESS(user);
    }

    /**
     * 根据id删除
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value = "id") String id) {
        userService.deleteById(id);
        return Result.SUCCESS();
    }
}
