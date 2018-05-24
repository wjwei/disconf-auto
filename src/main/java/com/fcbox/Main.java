package com.fcbox;

import com.fcbox.dto.DisconfAutoConfig;
import com.fcbox.operator.DisconfAutoOperator;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
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
            List<String> jarNames = Files.readAllLines(Paths.get(new URI(autoConfig.getDeployListPath())), Charset.forName("UTF-8"));
            String jarDir = autoConfig.getJarDir();

            for(String jarName : jarNames){
                //上传应用的disconf配置
                DisconfAutoOperator.uploadAppDisconf(jarDir, jarName);
            }
        } catch (Exception e) {
            log.error("发生异常：", e);
        }
    }
}
