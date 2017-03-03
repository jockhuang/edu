package cn.chineseall.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class FileUtil {

    private static Logger logger = Logger.getLogger(FileUtil.class);

    private static final int DEFAULT_BUFFER_SIZE = 1024 * 4;

    public static void copy(byte[] input, OutputStream output) throws IOException {
        output.write(input);
    }

    public static void copy(byte[] input, Writer output) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        copy(in, output);
    }

    public static void copy(byte[] input, Writer output, String encoding) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(input);
        copy(in, output, encoding);
    }

    public static int copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    public static int copy(Reader input, Writer output) throws IOException {
        char[] buffer = new char[DEFAULT_BUFFER_SIZE];
        int count = 0;
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    public static void copy(InputStream input, Writer output) throws IOException {
        InputStreamReader in = new InputStreamReader(input);
        copy(in, output);
    }

    public static void copy(InputStream input, Writer output, String encoding) throws IOException {
        InputStreamReader in = new InputStreamReader(input, encoding);
        copy(in, output);
    }

    public static void copy(Reader input, OutputStream output) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(output);
        copy(input, out);
        out.flush();
    }

    public static void copy(String input, OutputStream output) throws IOException {
        StringReader in = new StringReader(input);
        OutputStreamWriter out = new OutputStreamWriter(output);
        copy(in, out);
        out.flush();
    }

    public static void copy(String input, Writer output) throws IOException {
        output.write(input);
    }

    /**
     * 作者：liugang 2010-11-22 函数名称: saveFile 函数功能描述: 保存文件
     * 
     * @param input 保存的内容
     * @param filename 保存的文件名（完整的路径加上文件名）
     * @param encoding 文件编码
     * @throws IOException
     */
    public static void saveFile(String input, String filename, String encoding) throws IOException {
        File file = new File(filename);
        FileUtils.forceMkdir(new File(file.getParent()));
        FileUtils.writeStringToFile(file, input, encoding);

    }

    /**
     * 作者：liugang 2010-11-22 函数名称: readfile 函数功能描述: 读取文件内容
     * 
     * @param filename 完整的文件名（路径加上文件名）
     * @param charset 编码
     * @return //TODO <描述该参数的含义>
     */
    public static String readfile(String filename, String charset) {
        RandomAccessFile raf = null;
        FileChannel fc = null;
        ByteBuffer bb = null;
        CharBuffer cb = null;
        String str = "";
        try {
            raf = new RandomAccessFile(filename, "r");
            fc = raf.getChannel();
            bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, raf.length());
            Charset cs = Charset.forName(charset);
            cb = cs.decode(bb);
            str = cb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemory, using io read");
            str = readfileWithIO(filename, charset);
        } finally {
            try {
                cb = null;
                bb = null;
                fc.close();
                raf.close();
            } catch (Exception e) {
            }
        }
        return str;
    }

    /**
     * 作者：liugang 2010-11-22 函数名称: readfileWithIO 函数功能描述: 读取文件内容
     * 
     * @param fileName 完整的文件名（路径加上文件名）
     * @param charset 编码
     * @return //TODO <描述该参数的含义>
     */
    public static String readfileWithIO(String fileName, String charset) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader in = null;
        String line = "";
        File file = null;
        String returnString = "";
        try {
            file = new File(fileName);
            if (file.exists()) {
                in = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
                while ((line = in.readLine()) != null) {
                    stringBuffer.append(line).append("\r\n");
                }
                returnString = stringBuffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e) {
            System.out.println("OutOfMemory when read file with java.io");
        } finally {
            try {
                in.close();
                in = null;
                file = null;
                stringBuffer = null;
                line = null;
            } catch (IOException e) {
            }
        }
        return returnString;
    }

    public static void unZipFile(String targetPath, String zipFilePath) {
        try {
            File zipFile = new File(zipFilePath);
            InputStream is = new FileInputStream(zipFile);
            ZipInputStream zis = new ZipInputStream(is);
            ZipEntry entry = null;
            logger.info("开始解压:" + zipFile.getName() + "...");
            while ((entry = zis.getNextEntry()) != null) {
                String zipPath = entry.getName();
                try {
                    if (entry.isDirectory()) {
                        File zipFolder = new File(targetPath + File.separator + zipPath);
                        if (!zipFolder.exists()) {
                            zipFolder.mkdirs();
                        }
                    } else {
                        File file = new File(targetPath + File.separator + zipPath);
                        if (!file.exists()) {
                            File pathDir = file.getParentFile();
                            pathDir.mkdirs();
                            file.createNewFile();
                        }
                        FileOutputStream fos = new FileOutputStream(file);
                        int bread;
                        while ((bread = zis.read()) != -1) {
                            fos.write(bread);
                        }
                        fos.close();
                    }
                    logger.info("成功解压:" + zipPath);
                } catch (Exception e) {
                    logger.info("解压" + zipPath + "失败");
                    continue;
                }
            }
            zis.close();
            is.close();
            logger.info("解压结束");
            if (zipFile.exists()) {
                zipFile.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        FileUtil.unZipFile("/home/huqilong/bbb/", "/home/huqilong/Desktop/shanyao1215.zip");
    }
}
