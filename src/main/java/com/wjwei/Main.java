package com.wjwei;

import com.wjwei.dto.DisconfAutoConfig;
import com.wjwei.operator.DisconfAutoOperator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author 000298
 * @date 2018/4/25
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            //加载DisconfAuto配置信息
            DisconfAutoConfig autoConfig = DisconfAutoOperator.loadDisconfAutoConfig();

            //读出发布列表每行的应用名称
            InputStream stream = new FileInputStream(autoConfig.getDeployListPath());
            List<String> jarNames = IOUtils.readLines(stream);

            for(String jarName : jarNames){
                //上传应用的disconf配置
                DisconfAutoOperator.uploadAppDisconf(jarName, autoConfig);
            }
        } catch (Exception e) {
            log.error("发生异常：", e);
        }
    }
}
