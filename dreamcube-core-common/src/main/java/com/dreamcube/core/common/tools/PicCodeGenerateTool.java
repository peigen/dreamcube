/**
 * Richrent.com Inc.
 * Copyright (c) 2010-2011 All Rights Reserved.
 */
package com.dreamcube.core.common.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

/**
 * 图片校验码生成工具
 * 
 * @author holly Apr 9, 2010
 * 
 */
public class PicCodeGenerateTool {

    private static final Logger                logger         = LoggerFactory
                                                                  .getLogger(PicCodeGenerateTool.class);

    public static final String                 CHECK_CODD     = "checkCode";

    private Map<String, ByteArrayOutputStream> checkcodeCache = new ConcurrentHashMap<String, ByteArrayOutputStream>(
                                                                  10000);

    private WordImageProducer                  wordImageProducer;

    /**
     * @param request
     * @param modelMap
     */
    public void generateNewPicAuthCode(WebRequest request, ModelMap modelMap) {

        try {
            if (wordImageProducer == null) {
                wordImageProducer = new WordImageProducer();
                wordImageProducer.init();
            }
            // 生成验证码
            String checkcode = getRandomString(4, true);

            // 回写校验码
            modelMap.addAttribute(CHECK_CODD, getCheckcodeStream(checkcode).toByteArray());
            // 放入Session中，校验时使用
            request.setAttribute(CHECK_CODD, checkcode, RequestAttributes.SCOPE_SESSION);
        } catch (Exception e) {
            logger.error("[PicCodeGenerateTool:generateNewPicAuthCode]创建校验码图片时出现异常", e);
        }

    }

    /**
     * 生成校验码字节流
     * 
     * @param checkcode
     * @return ByteArrayOutputStream
     * @throws ImageFormatException
     * @throws IOException
     */
    protected ByteArrayOutputStream getCheckcodeStream(String checkcode) throws IOException {
        // 校验码Cache（key=checkcode；value=校验码字节流）
        if (checkcodeCache.containsKey(checkcode)) {

            PrintLogTool.info(checkcode + "的图片已经存在。", logger);
            // 从cache中直接返回
            return checkcodeCache.get(checkcode);
        } else {
            // cache中没有该checkcode
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            ImageIO.write(wordImageProducer.produce(checkcode), "png", os);

            // 将生成好的校验码字节流放到cache中
            checkcodeCache.put(checkcode, os);

            PrintLogTool.info("生成" + checkcode + "的图片校验码。", logger);
            return os;
        }
    }

    /**
     * 获取随机长度字符串
     * 
     * @param length
     *            字符串长度
     * @param includeLetter
     *            是否包含字母
     * @return 长度为length的字符串
     */
    private String getRandomString(int length, boolean includeLetter) {
        if (length < 1) {
            return "";
        }

        StringBuffer sb = new StringBuffer(length);

        for (int i = 0; i < length; i++) {
            sb.append(includeLetter ? genRandomChar(i != 0) : genRandomDigit(i != 0));
        }

        return sb.toString();
    }

    /**
     * 获取随机字符
     * 
     * @param allowZero
     * @return 随机字符
     */
    private char genRandomChar(boolean allowZero) {
        int randomNumber = 0;

        do {
            randomNumber = (int) (Math.random() * 36);
        } while ((randomNumber == 0) && !allowZero);

        if (randomNumber < 10) {
            return (char) (randomNumber + '0');
        } else {
            return (char) (randomNumber - 10 + 'a');
        }
    }

    /**
     * 获取随机数字
     * 
     * @param allowZero
     *            是否包含0
     * @return 随机数字
     */
    private char genRandomDigit(boolean allowZero) {
        int randomNumber = 0;

        do {
            randomNumber = (int) (Math.random() * 10);
        } while ((randomNumber == 0) && !allowZero);

        return (char) (randomNumber + '0');
    }

    //--------------------------------- setters --------------------------------//

    /**
     * @param wordImageProducer
     *            The wordImageProducer to set.
     */
    public void setWordImageProducer(WordImageProducer wordImageProducer) {
        this.wordImageProducer = wordImageProducer;
    }

}
