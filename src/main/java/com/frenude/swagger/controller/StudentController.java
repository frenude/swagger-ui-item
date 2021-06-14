package com.frenude.swagger.controller;

import com.frenude.swagger.common.CommonResult;
import com.frenude.swagger.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: Frenude
 * @mail: frenude@gmail.com
 * @date: created in 06 14,2021
 * @desc: //todo
 */
@Api(tags = "学生模块")
@RestController
public class StudentController {
    private static final HashMap<Integer, Student> map = new HashMap<>();

    static {
        map.put(1, new Student("Doris", 18));
        map.put(2, new Student("Tom", 22));
    }
    @ApiImplicitParam(name = "id",value = "学生ID",required = true)
    @ApiOperation(value = "通过ID获取学生")
    @GetMapping("/student/get/{id}")
    public CommonResult<Student> getStudentById(@PathVariable Integer id) {
        return CommonResult.success(HttpStatus.OK.value(), "Select SUCCESS!", map.get(id));
    }

}
