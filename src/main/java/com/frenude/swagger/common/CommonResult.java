package com.frenude.swagger.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Frenude
 * @mail: frenude@gmail.com
 * @date: created in 06 14,2021
 * @desc: //todo
 */
@Data
@ApiModel
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    @ApiModelProperty("状态")
    private Integer status = 1;
    @ApiModelProperty("状态码")
    private Integer code = 200;
    @ApiModelProperty("消息内容")
    private String msg = "";
    @ApiModelProperty("返回体")
    private T resultBody;
    public CommonResult(T resultBody) {
        this.resultBody = resultBody;
    }

    public static <T> CommonResult<T> success(Integer code,String msg,T resultBody)
    {
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.code = code;
        commonResult.msg = msg;
        commonResult.resultBody=resultBody;
        commonResult.status = 1;
        return commonResult;
    }
    public static <T> CommonResult<T> error(Integer code, String msg){
        CommonResult<T> commonResult = new CommonResult<>();
        commonResult.code = code;
        commonResult.msg = msg;
        commonResult.status = -1;
        return commonResult;
    }
}
