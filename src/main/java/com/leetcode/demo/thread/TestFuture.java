package com.leetcode.demo.thread;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;

import java.io.*;
import java.util.List;
import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 *
 * @author ldj
 * @Date: 2021/3/12 9:48
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TestFuture {
    public static void main(String[] args) throws IOException {

        File ufile = new File("E:\\cloudIpList.xlsx");

        ImportParams params = new ImportParams();
        params.setTitleRows(0);
        params.setHeadRows(1);
        List<CloudIpBean> allMapList = ExcelImportUtil.importExcel(ufile, CloudIpBean.class, params);
        FileOutputStream fileInputStream = new FileOutputStream(new File("E:\\test.txt"));
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileInputStream);
        int i = 0;
        for (CloudIpBean cloudIpBean : allMapList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("update cloud_master_manager set on_off_state=1 , cloud_ip=\"")
                    .append(cloudIpBean.getNewIp())
                    .append("\" where cloud_ip=\"")
                    .append(cloudIpBean.getOldIp())
                    .append("\"#").append("\n")
                    .append("update cloud_apply_record set cloud_ip=\"")
                    .append(cloudIpBean.getNewIp())
                    .append("\" where cloud_ip=\"")
                    .append(cloudIpBean.getOldIp())
                    .append("\"#").append("\n")
                    .append("update cloud_master_user_record set cloud_ip=\"")
                    .append(cloudIpBean.getNewIp())
                    .append("\" where cloud_ip=\"")
                    .append(cloudIpBean.getOldIp())
                    .append("\"");

            i += 3;
            if (i == 15) {
                stringBuilder.append("\n");
                stringBuilder.append("\n");
                i=0;
            } else {
                stringBuilder.append("#\n");
            }
            outputStreamWriter.write(stringBuilder.toString());
        }

        outputStreamWriter.close();
        fileInputStream.close();


    }


}
