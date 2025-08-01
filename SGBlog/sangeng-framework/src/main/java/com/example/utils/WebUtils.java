//package com.example.utils;
//
//import org.springframework.web.context.request.RequestContextHolder;
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//import java.net.URLEncoder;
//
///**
// * @author 35238
// * @date 2023/7/22 0022 21:19
// */
//public class WebUtils {
//    /**
//     * 将字符串渲染到客户端
//     *
//     * @param response 渲染对象
//     * @param string 待渲染的字符串
//     * @return null
//     */
//    //easyExcel文件导出失败时候做的操作
//    public static void renderString(HttpServletResponse response, String string) {
//        try
//        {
//            response.setStatus(200);
//            response.setContentType("application/json");
//            response.setCharacterEncoding("utf-8");
//            response.getWriter().print(string);
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//
//    //easyExcel文件导出
//    public static void setDownLoadHeader(String filename, ServletContext context, HttpServletResponse response) throws UnsupportedEncodingException {
//        String mimeType = context.getMimeType(filename);//获取文件的mime类型
//        response.setHeader("content-type",mimeType);
//        String fname= URLEncoder.encode(filename,"UTF-8");
//        response.setHeader("Content-disposition","attachment; filename="+fname);
//
////        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
////        response.setCharacterEncoding("utf-8");
//    }
//}

package com.example.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WebUtils {

    /**
     * 渲染字符串到客户端（用于错误输出）
     */
    public static void renderString(HttpServletResponse response, String string) {
        try {
            response.setStatus(200);
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置下载 Excel 文件的响应头
     */
    public static void setDownLoadHeader(String filename, HttpServletResponse response) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");

        String fname = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-Disposition", "attachment; filename=" + fname);
    }
}
