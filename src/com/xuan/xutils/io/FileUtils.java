package com.xuan.xutils.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.�ļ�����������
 * User: ����
 * Date: 2017-10-16
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 */
public abstract class FileUtils {
    public static final String EMPTY = "";
    public static final long ONE_KB = 1024;
    public static final long ONE_MB = ONE_KB * ONE_KB;
    public static final long ONE_GB = ONE_KB * ONE_MB;
    public static final long ONE_TB = ONE_KB * ONE_GB;
    public static final long ONE_PB = ONE_KB * ONE_TB;
    public static final long ONE_EB = ONE_KB * ONE_PB;
    private static final long FILE_COPY_BUFFER_SIZE = ONE_MB * 30;

    /**
     * ��ȡ�ļ��ĺ�׺���������ļ�����xuan.jpgʱ�����صĺ�׺��ʱjpg
     *
     * @param fileName �ļ���
     * @return ��׺��
     */
    public static String getExtension(String fileName) {
        if (null == fileName) {
            return EMPTY;
        }
        int pointIndex = fileName.lastIndexOf(".");
        return pointIndex > 0 && pointIndex < fileName.length() ? fileName.substring(pointIndex + 1).toLowerCase() : EMPTY;
    }
    // ////////////////////�ֽ�д������ļ�������һ���������дͼƬ��������////////////////////

    /**
     * �ֽ�д�뵽�ļ���
     *
     * @param file   �ļ�
     * @param data   �ֽ�����
     * @param append �Ƿ���ļ��������
     * @throws IOException
     */
    public static void writeByteArrayToFile(File file, byte[] data, boolean append) throws IOException {
        OutputStream out = null;
        try {
            out = openOutputStream(file, append);
            out.write(data);
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * �����ļ��е��ֽ�
     *
     * @param file �ļ�
     * @return �ֽ�����
     * @throws IOException
     */
    public static byte[] readFileToByteArray(File file) throws IOException {
        InputStream in = null;
        try {
            in = openInputStream(file);
            return IOUtils.toByteArray(in, file.length());
        } finally {
            IOUtils.closeQuietly(in);
        }
    }
    // ////////////////////�ַ������ļ���д���������////////////////////

    /**
     * ����д���ļ�
     *
     * @param file     Ҫд����ļ�
     * @param data     ����
     * @param encoding ָ������
     * @param append   �Ƿ�׷��
     * @throws IOException
     */
    public static void writeStringToFile(File file, String data, String encoding, boolean append) throws IOException {
        OutputStream out = null;
        try {
            out = openOutputStream(file, append);
            IOUtils.write(data, out, encoding);
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * ���ļ�����ָ�������ȡ���ַ���
     *
     * @param file     �ļ�
     * @param encoding ����
     * @return
     * @throws IOException
     */
    public static String readFileToString(File file, String encoding) throws IOException {
        InputStream in = null;
        try {
            in = openInputStream(file);
            return IOUtils.toString(in, encoding);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }
    // ////////////////////���������������////////////////////

    /**
     * ��һ���ļ���д�������ļ������ڻ��Զ�����
     *
     * @param file   �ļ�
     * @param append �Ƿ���׷�ӵķ�ʽд��
     * @return
     * @throws IOException
     */
    public static FileOutputStream openOutputStream(File file, boolean append) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (file.canWrite() == false) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        } else {
            File parent = file.getParentFile();
            if (parent != null) {
                if (!parent.mkdirs() && !parent.isDirectory()) {
                    throw new IOException("Directory '" + parent + "' could not be created");
                }
            }
        }
        return new FileOutputStream(file, append);
    }

    /**
     * ���ļ���������У���Ѻõ���ʾ
     *
     * @param file Ҫ�򿪵��ļ�
     * @return
     * @throws IOException
     */
    public static FileInputStream openInputStream(File file) throws IOException {
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (file.canRead() == false) {
                throw new IOException("File '" + file + "' cannot be read");
            }
        } else {
            throw new FileNotFoundException("File '" + file + "' does not exist");
        }
        return new FileInputStream(file);
    }
    // ////////////////////�ļ���λ�ֽ��Ѻ����////////////////////

    /**
     * �Ѻõ���ʾ��λ�������е����⣬���磺byteCountToDisplaySize(2047)��ʾ1K��������������
     *
     * @param size byte��λֵ
     * @return
     */
    public static String byteCountToDisplaySize(long size) {
        String displaySize;
        if (size / ONE_EB > 0) {
            displaySize = String.valueOf(size / ONE_EB) + " EB";
        } else if (size / ONE_EB > 0) {
            displaySize = String.valueOf(size / ONE_EB) + " PB";
        } else if (size / ONE_TB > 0) {
            displaySize = String.valueOf(size / ONE_TB) + " TB";
        } else if (size / ONE_GB > 0) {
            displaySize = String.valueOf(size / ONE_GB) + " GB";
        } else if (size / ONE_MB > 0) {
            displaySize = String.valueOf(size / ONE_MB) + " MB";
        } else if (size / ONE_KB > 0) {
            displaySize = String.valueOf(size / ONE_KB) + " KB";
        } else {
            displaySize = String.valueOf(size) + " bytes";
        }
        return displaySize;
    }
    // ////////////////////�ƶ��ļ�////////////////////

    /**
     * �����ļ��е��ļ���
     *
     * @param src     Դ�ļ���
     * @param destDir Ŀ���ļ���
     * @param isCover �����Ƿ񸲸�
     * @throws IOException
     */
    public static void moveDirectoryToDirectory(File src, File destDir, boolean isCover) throws IOException {
        if (src == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (destDir == null) {
            throw new NullPointerException("Destination directory must not be null");
        }
        if (destDir.exists()) {
            if (isCover) {
                deleteFileOrDirectoryQuietly(destDir.getPath());
            } else {
                throw new IOException("Destination directory is exists and isCover=false");
            }
        }
        destDir.mkdirs();
        if (!destDir.exists()) {
            throw new FileNotFoundException("Destination directory '" + destDir + "' create failed]");
        }
        if (!destDir.isDirectory()) {
            throw new IOException("Destination '" + destDir + "' is not a directory");
        }
        boolean rename = src.renameTo(destDir);
        if (!rename) {
            if (destDir.getCanonicalPath().startsWith(src.getCanonicalPath())) {
                throw new IOException("Cannot move directory: " + src + " to a subdirectory of itself: " + destDir);
            }
            copyDirectoryToDirectory(src, destDir);
            deleteFileOrDirectoryQuietly(src.getPath());
            if (src.exists()) {
                throw new IOException("Failed to delete original directory '" + src + "' after copy to '" + destDir + "'");
            }
        }
    }

    /**
     * �����ļ����ļ���
     *
     * @param srcFile Դ�ļ�
     * @param destDir Ŀ���ļ���
     * @param isCover �����Ƿ񸲸�
     * @throws IOException
     */
    public static void moveFileToDirectory(File srcFile, File destDir, boolean isCover) throws IOException {
        if (srcFile == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (destDir == null) {
            throw new NullPointerException("Destination directory must not be null");
        }
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
        if (!destDir.exists()) {
            throw new FileNotFoundException("Destination directory '" + destDir + "' create failed]");
        }
        if (!destDir.isDirectory()) {
            throw new IOException("Destination '" + destDir + "' is not a directory");
        }
        moveFile(srcFile, new File(destDir, srcFile.getName()), isCover);
    }

    /**
     * �����ļ����ļ�
     *
     * @param srcFile  Դ�ļ�
     * @param destFile Ŀ���ļ�
     * @param isCover  �����Ƿ񸲸�
     * @throws IOException
     */
    public static void moveFile(File srcFile, File destFile, boolean isCover) throws IOException {
        if (null == srcFile) {
            throw new NullPointerException("Source must not be null");
        }
        if (null == destFile) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!srcFile.exists()) {
            throw new FileNotFoundException("Source '" + srcFile + "' does not exist");
        }
        if (srcFile.isDirectory()) {
            throw new IOException("Source '" + srcFile + "' is a directory");
        }
        if (destFile.isDirectory()) {
            throw new IOException("Destination '" + destFile + "' is a directory");
        }
        if (destFile.exists()) {
            if (isCover) {
                deleteFileOrDirectoryQuietly(destFile.getPath());
            } else {
                throw new IOException("Destination directory is exists and isCover=false");
            }
        }
        boolean rename = srcFile.renameTo(destFile);
        if (!rename) {
            copyFile(srcFile, destFile);
            if (!srcFile.delete()) {
                deleteFileOrDirectoryQuietly(destFile.getPath());
                throw new IOException("Failed to delete original file '" + srcFile + "' after copy to '" + destFile + "'");
            }
        }
    }
    // ////////////////////�ļ������ݿ�����ָ���ļ�����////////////////////

    /**
     * �����ļ��е��ļ���
     *
     * @param srcDir  Դ�ļ���
     * @param destDir Ŀ���ļ���
     * @throws IOException
     */
    public static void copyDirectoryToDirectory(File srcDir, File destDir) throws IOException {
        copyDirectoryToDirectory(srcDir, new File(destDir, srcDir.getName()), null);
    }

    /**
     * �����ļ��е��ļ���
     *
     * @param srcDir  Դ�ļ���
     * @param destDir Ŀ���ļ���
     * @param filter  �ļ�������
     * @throws IOException
     */
    public static void copyDirectoryToDirectory(File srcDir, File destDir, FileFilter filter) throws IOException {
        if (srcDir == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (destDir == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (srcDir.exists() && !srcDir.isDirectory()) {
            throw new IllegalArgumentException("Source '" + destDir + "' is not a directory");
        }
        if (destDir.exists() && !destDir.isDirectory()) {
            throw new IllegalArgumentException("Destination '" + destDir + "' is not a directory");
        }
        if (!srcDir.exists()) {
            throw new FileNotFoundException("Source '" + srcDir + "' does not exist");
        }
        if (srcDir.getCanonicalPath().equals(destDir.getCanonicalPath())) {
            throw new IOException("Source '" + srcDir + "' and destination '" + destDir + "' are the same");
        }
        // Cater for destination being directory within the source directory
        // (see IO-141)
        List<String> exclusionList = null;
        if (destDir.getCanonicalPath().startsWith(srcDir.getCanonicalPath())) {
            File[] srcFiles = null == filter ? srcDir.listFiles() : srcDir.listFiles(filter);
            if (srcFiles != null && srcFiles.length > 0) {
                exclusionList = new ArrayList<String>(srcFiles.length);
                for (File srcFile : srcFiles) {
                    File copiedFile = new File(destDir, srcFile.getName());
                    exclusionList.add(copiedFile.getCanonicalPath());
                }
            }
        }
        doCopyDirectory(srcDir, destDir, filter, true, exclusionList);
    }

    private static void doCopyDirectory(File srcDir, File destDir, FileFilter filter, boolean preserveFileDate, List<String> exclusionList) throws IOException {
        // recurse
        File[] srcFiles = (null == filter) ? srcDir.listFiles() : srcDir.listFiles(filter);
        if (srcFiles == null) { // null if abstract pathname does not denote a
            // directory, or if an I/O error occurs
            throw new IOException("Failed to list contents of " + srcDir);
        }
        if (destDir.exists()) {
            if (!destDir.isDirectory()) {
                throw new IOException("Destination '" + destDir + "' exists but is not a directory");
            }
        } else {
            if (!destDir.mkdirs() && !destDir.isDirectory()) {
                throw new IOException("Destination '" + destDir + "' directory cannot be created");
            }
        }
        if (!destDir.canWrite()) {
            throw new IOException("Destination '" + destDir + "' cannot be written to");
        }
        for (File srcFile : srcFiles) {
            File dstFile = new File(destDir, srcFile.getName());
            if (exclusionList == null || !exclusionList.contains(srcFile.getCanonicalPath())) {
                if (srcFile.isDirectory()) {
                    doCopyDirectory(srcFile, dstFile, filter, preserveFileDate, exclusionList);
                } else {
                    doCopyFile(srcFile, dstFile, preserveFileDate);
                }
            }
        }
        if (preserveFileDate) {
            destDir.setLastModified(srcDir.lastModified());
        }
    }
    // ////////////////////�ļ�������ָ���ļ�����////////////////////

    /**
     * �����ļ����ļ���
     *
     * @param srcFile Դ�ļ�
     * @param destDir Ŀ���ļ���
     * @throws IOException
     */
    public static void copyFileToDirectory(File srcFile, File destDir) throws IOException {
        copyFileToDirectory(srcFile, destDir, true);
    }

    /**
     * �����ļ����ļ���
     *
     * @param srcFile          Դ�ļ�
     * @param destDir          Ŀ���ļ���
     * @param preserveFileDate �Ƿ��޸�ʱ��
     * @throws IOException
     */
    public static void copyFileToDirectory(File srcFile, File destDir, boolean preserveFileDate) throws IOException {
        if (null == destDir) {
            throw new NullPointerException("Destination must not be null");
        }
        if (destDir.exists() && !destDir.isDirectory()) {
            throw new IllegalArgumentException("Destination '" + destDir + "' is not a directory");
        }
        File destFile = new File(destDir, srcFile.getName());
        copyFile(srcFile, destFile, preserveFileDate);
    }
    // ////////////////////�ļ��������ļ�////////////////////

    /**
     * �����ļ����ļ�
     *
     * @param srcFile  Դ�ļ�
     * @param destFile Ŀ���ļ�
     * @throws IOException
     */
    public static void copyFile(File srcFile, File destFile) throws IOException {
        copyFile(srcFile, destFile, true);
    }

    /**
     * �����ļ����ļ�
     *
     * @param srcFile          Դ�ļ�
     * @param destFile         Ŀ���ļ�
     * @param preserveFileDate �Ƿ��޸�ʱ��
     * @throws IOException
     */
    public static void copyFile(File srcFile, File destFile, boolean preserveFileDate) throws IOException {
        if (srcFile == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (destFile == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (!srcFile.exists()) {// Դ������
            throw new FileNotFoundException("Source '" + srcFile + "' does not exist");
        }
        if (destFile.isDirectory()) {// Դ���ڣ������Ǹ�Ŀ¼
            throw new IOException("Destination '" + destFile + "' exists but is a directory");
        }
        if (srcFile.getCanonicalPath().equals(destFile.getCanonicalPath())) {// ָ����ͬһ���ļ�
            throw new IOException("Source '" + srcFile + "' and destination '" + destFile + "' are the same");
        }
        if (destFile.exists() && !destFile.canWrite()) {// Ŀ���ļ����ڣ�û��дȨ��
            throw new IOException("Destination '" + destFile + "' exists but is read-only");
        }
        // �������ļ���
        File parentFile = destFile.getParentFile();
        if (null != parentFile) {
            if (!parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Destination '" + parentFile + "' directory cannot be created");
            }
        }
        doCopyFile(srcFile, destFile, preserveFileDate);
    }

    private static void doCopyFile(File srcFile, File destFile, boolean preserveFileDate) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel input = null;
        FileChannel output = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);
            input = fis.getChannel();
            output = fos.getChannel();
            long size = input.size();
            long pos = 0;
            long count = 0;
            while (pos < size) {
                count = size - pos > FILE_COPY_BUFFER_SIZE ? FILE_COPY_BUFFER_SIZE : size - pos;
                pos += output.transferFrom(input, pos, count);
            }
        } finally {
            IOUtils.closeQuietly(output);
            IOUtils.closeQuietly(fos);
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(fis);
        }
        if (srcFile.length() != destFile.length()) {
            throw new IOException("Failed to copy full contents from '" + srcFile + "' to '" + destFile + "'");
        }
        if (preserveFileDate) {// �޸��ļ�����޸�ʱ��
            destFile.setLastModified(srcFile.lastModified());
        }
    }
    // ////////////////////�ݹ�ɾ���ļ����µ������ļ�////////////////////

    /**
     * ɾ��ָ��Ŀ¼���ļ���Ŀ¼��Ĭ�ϱ���Ҳ�ᱻɾ��
     *
     * @param filePath �ļ������ļ���·��
     */
    public static void deleteFileOrDirectoryQuietly(String filePath) {
        try {
            deleteFileOrDirectory(filePath, true);
        } catch (Exception e) {
            // Ignore
        }
    }

    /**
     * ɾ��ָ��Ŀ¼���ļ���Ŀ¼
     *
     * @param filePath       �ļ������ļ���·��
     * @param deleteThisPath �Ƿ���Ҫɾ���������ָ�����ļ������ļ���
     */
    public static void deleteFileOrDirectory(String filePath, boolean deleteThisPath) throws IOException {
        if (null != filePath && filePath.length() > 0) {
            File file = new File(filePath);
            if (file.isDirectory()) {// ����Ŀ¼
                File files[] = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteFileOrDirectory(files[i].getAbsolutePath(), true);
                }
            }
            if (deleteThisPath) {
                if (!file.isDirectory()) {// ������ļ���ɾ��
                    file.delete();
                } else {// Ŀ¼
                    if (file.listFiles().length == 0) {// Ŀ¼��û���ļ�����Ŀ¼��ɾ��
                        file.delete();
                    }
                }
            }
        }
    }
    // ////////////////////�ݹ��ȡ�ļ�������������ļ�////////////////////

    /**
     * ��ȡָ��·���µ������ļ�
     *
     * @param path ָ��·��
     * @return
     */
    public static List<File> getFileListByPath(String path) {
        return getFileListByPath(path, null);
    }

    /**
     * ��ȡָ��·���µ������ļ�
     *
     * @param path   ָ��·��
     * @param filter �ļ�������
     * @return
     */
    public static List<File> getFileListByPath(String path, FileFilter filter) {
        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Nonexistent directory[" + path + "]");
        }
        return new Recursiver().getFileList(directory, filter);
    }
    // ////////////////////����Properties�ļ�////////////////////

    /**
     * ��ȡָ��·����Properties�ļ�
     *
     * @param path ·��
     * @return Properties����
     */
    public static Properties readProperties(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        Properties properties = new Properties();
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Could not read Properties[" + path + "]", e);
        } finally {
            IOUtils.closeQuietly(in);
        }
        return properties;
    }

    /**
     * ����������ȡProperties����
     *
     * @param in ������
     * @return Properties����
     */
    public static Properties readProperties(InputStream in) {
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Could not read Properties", e);
        } finally {
            IOUtils.closeQuietly(in);
        }
        return properties;
    }

    /**
     * ��Properties����д��ָ��·�����ļ���
     *
     * @param path       ·��
     * @param properties Properties����
     */
    public static void writeProperties(String path, Properties properties) {
        OutputStream out = null;
        try {
            out = new FileOutputStream(path);
            properties.store(out, null);
        } catch (IOException e) {
            throw new RuntimeException("Could not write Properties[" + path + "]", e);
        } finally {
            IOUtils.closeQuietly(out);
        }
    }

    /**
     * �ݹ��ȡָ��Ŀ¼�µ������ļ��ı�����
     *
     * @author xuan
     * @version $Revision: 1.0 $, $Date: 2013-9-5 ����1:13:17 $
     */
    private static class Recursiver {
        private static ArrayList<File> files = new ArrayList<File>();

        public List<File> getFileList(File file, FileFilter filter) {
            File children[] = null == filter ? file.listFiles() : file.listFiles(filter);
            for (int i = 0; i < children.length; i++) {
                if (children[i].isDirectory()) {
                    new Recursiver().getFileList(children[i], filter);
                } else {
                    files.add(children[i]);
                }
            }
            return files;
        }
    }
}
