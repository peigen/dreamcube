/**
 * Alipay.com Inc.
 * Copyright (c) 2010-2011 All Rights Reserved.
 */
package com.dreamcube.framework.views;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractUrlBasedView;

/**
 * 图片校验码生成View
 * 
 * @author holly Apr 8, 2010
 */
@SuppressWarnings("rawtypes")
public class DreamCubeCheckCodeView extends AbstractUrlBasedView {

    /**
     * This constructor sets the appropriate content type "image/jpeg".
     * 
     */
    public DreamCubeCheckCodeView() {
        setContentType("image/jpeg");
    }

    protected void renderMergedOutputModel(final Map model, HttpServletRequest request,
                                           HttpServletResponse response) throws Exception {
        prepareResponse(model, response);
        byte[] processedData = prepareSourceData(model, request, response);
        // Write content type and also length (determined via byte array).
        response.setContentLength(processedData.length);

        // Flush byte array to servlet output stream.
        ServletOutputStream out = response.getOutputStream();
        out.write(processedData);
        out.flush();
    }

    /**
     * 获取取源文件数据，如果没有数据流，再从源文件读取，子类可以重写
     * @param model 
     * @param request 
     * @param response
     * @return
     * @throws IOException
     */
    protected byte[] prepareSourceData(final Map model, HttpServletRequest request,
                                       HttpServletResponse response) throws IOException {
        byte[] sourceData = (byte[]) model.get("checkCode");

        return sourceData;
    }

    /**
     * 设置下载的response header
     * @param model 模型对象
     * @param response 
     * @throws UnsupportedEncodingException 
     */
    protected void prepareResponse(final Map model, HttpServletResponse response)
                                                                                 throws UnsupportedEncodingException {
        response.setContentType(getContentType());

        response.setHeader("Expires", "Sat, 16 Jan 1980 12:00:00 GMT");
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
    }

}
