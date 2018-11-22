package com.wjwei.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 000298
 * @date 2018/4/28
 */
@Getter
@Setter
@ToString
public class DisconfAutoConfig {

    private String deployListPath;
    private String deployJarsDir;

    private String disconfHostUserNamePwd;
}
