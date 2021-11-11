package com.generator;

import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.util.StringHelper;

/**
 * 重写GeneratorFacade
 *
 * @author wliduo[i@dolyw.com]
 * @date 2019/4/6 19:36
 */
public class CustomGeneratorFacade extends GeneratorFacade {

    /**
     * CustomGeneratorFacade
     *
     * @param outRootDir
     * @author wliduo[i@dolyw.com]
     * @date 2019/4/8 9:27
     */
    public CustomGeneratorFacade(String outRootDir) {
        if (StringHelper.isNotBlank(outRootDir)) {
            super.getGenerator().setOutRootDir(outRootDir);
        }
    }

}
