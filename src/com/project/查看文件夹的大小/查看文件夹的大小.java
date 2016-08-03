package com.project.查看文件夹的大小;

import com.xl.file.FileService;
import com.xl.util.FileTool;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 查看文件夹的大小 {
    String filePath = "";
    private File dir = new File("E:");
    private List<File> fileList = new ArrayList<File>();
    private FileService service = new FileService();

    @Before
    public void init() {
        filePath = getClass().getClassLoader().getResource("").getPath();
    }

    @Test
    public void test1() {
        LogFactory.getLog(this.getClass()).info(filePath);
        dir = new File(filePath);
        File[] file = dir.listFiles();
        fileList.addAll(Arrays.asList(file));
        print(fileList);
    }

    private void print(List<File> fileList) {
        for (File file : fileList) {
            if (file.isDirectory()) {
                System.out.println(file.getPath() + "\t" + FileTool.getSize(service.getFileSize(file)) + "\t" + service.getFileSize(file));
            } else {
                System.out.println(file.getPath() + "\t" + FileTool.getSize(file.length()) + "\t" + file.length());
            }
        }
    }
}
