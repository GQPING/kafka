package com.dpim.kafka.utils.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author chengxianwei
 * @description 导出数据到Excel工具类
 * @date 2021/9/26 9:27
 */
@Slf4j
public class ExcelUtils {

    /**
     * 导出数据到一个Excel文件
     * @param response HttpServletResponse
     * @param obj 导出的实体类数据模板
     * @param list 导出的数据 list
     * @param fileName 导出的文件名
     * @param sheetName 导出文件的 sheet 名
     * @author chengxianwei
     * @date 2021/9/26 9:52
     */
    public static void downloadExcel(HttpServletResponse response, Class obj, List list, String fileName, String sheetName) throws Exception {
        try {
            // 设置内容格式
            // application/vnd.ms-excel 对应 .xls
            // application/vnd.openxmlformats-officedocument.spreadsheetml.sheet 对应 .xlsx
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            // 设置字符编码
            response.setCharacterEncoding("utf-8");
            // 设置响应头信息
            response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(fileName + ".xlsx", "utf-8"));
            //用io流来写入数据，这里需要设置不关闭流
            EasyExcel.write(response.getOutputStream(), obj).sheet(sheetName).doWrite(list);
        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            throw new Exception(e.getMessage());
        }
    }

    /**
     * 单工作表 Excel表格导出，自动列宽
     * @param response HttpServletResponse
     * @param clazz 实体类
     * @param date 数据List
     * @param fileName 文件名
     * @throws IOException 获取输出流异常
     * @Author 朱山威林
     */
    public static void downloadExcel(HttpServletResponse response,Class clazz,List date,String fileName)  {
       try {
           response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
           response.setCharacterEncoding("utf-8");
           response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + URLEncoder.encode(fileName + ".xlsx", "utf-8"));
           // 头的策略
           WriteCellStyle headWriteCellStyle = new WriteCellStyle();
           WriteFont headWriteFont = new WriteFont();
           headWriteFont.setFontHeightInPoints((short)16);
           headWriteCellStyle.setWriteFont(headWriteFont);
           // 背景设置为淡蓝色
           headWriteCellStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
           // 内容的策略
           WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
           //设置字体样式
           WriteFont contentWriteFont = new WriteFont();
           contentWriteFont.setFontHeightInPoints((short)14);
           contentWriteCellStyle.setWriteFont(contentWriteFont);
           //设置居中对齐
           contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
           contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
           // 这个策略是 头是头的样式 内容是内容的样式
           HorizontalCellStyleStrategy horizontalCellStyleStrategy =
                   new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);

           EasyExcel.write(response.getOutputStream(), clazz)
                   .autoCloseStream(Boolean.FALSE)
                   .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                   .registerWriteHandler(horizontalCellStyleStrategy)
                   .sheet("sheet0")
                   .doWrite(date);
       }catch (Exception e){
           log.error(e.getMessage());
           response.reset();
           response.setContentType("application/json");
           response.setCharacterEncoding("utf-8");
       }
    }
}
