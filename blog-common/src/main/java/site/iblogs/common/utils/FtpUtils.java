package site.iblogs.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FilenameUtils;

/**
 * -FTP工具类（common-net:ftp）
 *     -注意：
 *         1.-ftpClient.changeWorkingDirectory(ftpPath)，切换ftp目录会产生权限问题，需谨慎使用
 *         2.-ftpPath可以写相对路径或绝对路径，一般填写绝对路径，以防止工作目录的切换产生权限问题；如果是相对路径，一般需要切换回根目录
 * @author sixmonth
 * @Date 2019年12月19日
 *
 */
public class FtpUtils {

    private static Logger logger = LoggerFactory.getLogger(FtpUtils.class);

    // ftp服务器地址
    public String hostname = "47.111.111.111";
    // ftp服务器端口号
    public Integer port = 21;
    // ftp登录账号
    public String username = "test";
    // ftp登录密码
    public String password = "123456";
    // ftp根目录（自定义，即vsftpd.conf属性配置，ep：local_root=/var/ftp/test）
    public static String rootPath = "/var/ftp/test/";

    /**
     * --初始化ftp服务器
     */
    public FTPClient initFtpClient() {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");
        try {
            logger.info("连接ftp服务器：" + this.hostname + ":" + this.port);
            ftpClient.connect(hostname, port); // 连接ftp服务器
            ftpClient.login(username, password); // 登录ftp服务器
            int replyCode = ftpClient.getReplyCode(); // 是否成功登录服务器
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                logger.info("ftp连接失败！");
            } else {
                logger.info("ftp连接成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ftpClient;
    }

    /**
     * -工作目录切换回根目录
     *
     * @param ftpClient
     * @throws IOException
     */
    public void changeRootDirectory(FTPClient ftpClient) throws IOException {
        ftpClient.changeWorkingDirectory(rootPath);
    }

    /**
     * -上传文件
     * @param ftpClient
     * @param ftpPath
     *            -ftp服务保存地址（归属多层文件夹） -注意：
     *            1.-当前ftpPath属于多层文件夹，一般写法为：sixmonth/day1；sixmonth/day2
     *            2.-也可以写成服务器的绝对路径，绝对路径则属于单层文件夹，写法为：/var/ftp/test
     * @param newFileName
     *            -上传到ftp的新文件名，有无后缀都行
     * @param originfile
     *            -待上传文件（文件绝对地址）
     * @return
     */
    public boolean uploadFile(FTPClient ftpClient, String ftpPath, String newFileName, String originfile) {
        InputStream inputStream = null;
        try {
            logger.info("开始上传文件");
            changeRootDirectory(ftpClient);// 切换根目录
            inputStream = new FileInputStream(new File(originfile));
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            ftpClient.setControlEncoding("UTF-8");

            CreateDirecroty(ftpClient, ftpPath);
            ftpClient.makeDirectory(ftpPath);

            // 切换ftp工作目录，会产生权限问题，需谨慎使用
            ftpClient.changeWorkingDirectory(ftpPath);

            // 每次数据连接之前，ftp client告诉ftp server开通一个端口来传输数据
            ftpClient.enterLocalPassiveMode();
            // 设置传输模式
            ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);

            String temName = newFileName;
            if (newFileName.indexOf(".") == -1) {
                temName = newFileName + "." + FilenameUtils.getExtension(originfile);
            }

            // 观察是否真的上传成功
            boolean storeFlag = ftpClient.storeFile(temName, inputStream);
            // boolean storeFlag = ftpClient.storeFile(new
            // String(fileName.getBytes("UTF-8"), "ISO-8859-1"), inputStream);
            System.err.println("storeFlag==" + storeFlag);
            inputStream.close();
            logger.info("上传文件成功");
        } catch (Exception e) {
            logger.info("上传文件失败");
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * -上传文件
     * @param ftpClient
     * @param ftpPath
     *            -ftp服务保存地址（归属多层文件夹） -注意：
     *            1.-当前ftpPath属于多层文件夹，一般写法为：sixmonth/day1；sixmonth/day2
     *            2.-也可以写成服务器的绝对路径，绝对路径则属于单层文件夹，写法为：/var/ftp/test
     * @param newFileName
     *            -上传到ftp的文件名，必须有后缀，ep：test.txt
     * @param inputStream
     *            -输入文件流
     * @return
     */
    public boolean uploadFile(FTPClient ftpClient, String ftpPath, String newFileName, InputStream inputStream) {
        try {
            logger.info("开始上传文件");
            changeRootDirectory(ftpClient);// 切换根目录
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            CreateDirecroty(ftpClient, ftpPath);
            ftpClient.makeDirectory(ftpPath);
            // 切换ftp工作目录，会产生权限问题，需谨慎使用
            ftpClient.changeWorkingDirectory(ftpPath);
            ftpClient.storeFile(newFileName, inputStream);
            inputStream.close();
            logger.info("上传文件成功");
        } catch (Exception e) {
            logger.error("上传文件失败");
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * -切换ftp目录
     * @param ftpClient
     * @param directory -ftp路径
     * @return
     */
    public boolean changeWorkingDirectory(FTPClient ftpClient, String directory) {
        boolean flag = true;
        try {
            flag = ftpClient.changeWorkingDirectory(directory);
            if (flag) {
                logger.info("进入文件夹" + directory + " 成功！");
            } else {
                logger.info("进入文件夹" + directory + " 失败！开始创建文件夹");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return flag;
    }

    /**
     * -创建多层目录文件夹，如果有ftp服务器已存在该文件，则不创建，如果无，则创建
     * @param ftpClient
     * @param remoteDir -ftp文件夹
     * @return
     * @throws IOException
     */
    public boolean CreateDirecroty(FTPClient ftpClient, String remoteDir) throws IOException {
        boolean success = true;
        String directory = remoteDir + "/";
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/") && !changeWorkingDirectory(ftpClient, new String(directory))) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            String path = "";
            String paths = "";
            while (true) {
                String subDirectory = new String(remoteDir.substring(start, end).getBytes("GBK"), "iso-8859-1");
                path = path + "/" + subDirectory;
                if (!existFile(ftpClient, path)) {
                    if (makeDirectory(ftpClient, subDirectory)) {
                        changeWorkingDirectory(ftpClient, subDirectory);
                    } else {
                        logger.info("创建目录[" + subDirectory + "]失败");
                        changeWorkingDirectory(ftpClient, subDirectory);
                    }
                } else {
                    changeWorkingDirectory(ftpClient, subDirectory);
                }

                paths = paths + "/" + subDirectory;
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }

    /**
     * -判断ftp服务器文件是否存在
     * @param ftpClient
     * @param path -文件相对路径或绝对路径
     * @return
     * @throws IOException
     */
    public boolean existFile(FTPClient ftpClient, String path) throws IOException {
        boolean flag = false;
        FTPFile[] ftpFileArr = ftpClient.listFiles(path);
        if (ftpFileArr.length > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * -创建ftp目录
     * @param ftpClient
     * @param dir
     * @return
     */
    public boolean makeDirectory(FTPClient ftpClient, String dir) {
        boolean flag = true;
        try {
            flag = ftpClient.makeDirectory(dir);
            if (flag) {
                logger.info("创建文件夹" + dir + " 成功！");
            } else {
                logger.info("创建文件夹" + dir + " 失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * - 下载文件
     * @param ftpClient
     * @param ftpPath
     *            -FTP服务器文件目录
     * @param filename
     *            -文件名称
     * @param localpath
     *            -下载后的文件路径
     * @return
     */
    public boolean downloadFile(FTPClient ftpClient, String ftpPath, String filename, String localpath) {
        boolean flag = false;
        OutputStream os = null;
        try {
            logger.info("开始下载文件");

            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);// 传输的时候以二进制传输
            ftpClient.enterLocalPassiveMode();
            // ftpClient.setRemoteVerificationEnabled(false);

            // ftpClient.configure(new
            // FTPClientConfig("com.zznode.tnms.ra.c11n.nj.resource.ftp.UnixFTPEntryParser"));
            // 由于apache不支持中文语言环境，通过定制类解析中文日期类型
            ftpClient.configure(new FTPClientConfig("com.zznode.tnms.ra.c11n.nj.resource.ftp.UnixFTPEntryParser"));

            //切换FTP目录
            ftpClient.changeWorkingDirectory(ftpPath);

            // 查看有哪些文件夹 以确定切换的ftp路径正确
            String[] a = ftpClient.listNames();
            logger.info(a[0]);

            FTPFile[] ftpFiles = ftpClient.listFiles();
            for (FTPFile file : ftpFiles) {
                if (filename.equalsIgnoreCase(file.getName())) {
                    File localFile = new File(localpath + "/" + file.getName());
                    os = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(file.getName(), os);
                    os.close();
                }
            }
            flag = true;
            logger.info("下载文件成功");
        } catch (Exception e) {
            logger.info("下载文件失败");
            e.printStackTrace();
        } finally {
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }

    /**
     * -递归遍历出目录下面所有文件
     * @param ftpClient
     * @param ftpPath
     *            ftp相对路径或绝对路径
     * @param filePathsArr
     *            需要返回的文件路径集合
     * @return
     * @throws IOException
     */
    public List<String> listFiles(FTPClient ftpClient, String ftpPath, List<String> filePathsArr) throws IOException {
        FTPFile[] files = ftpClient.listFiles(ftpPath);
        for (FTPFile file : files) {
            String path = ftpPath + "/" + file.getName();
            if (file.isFile()) {
                filePathsArr.add(path);
            } else if (file.isDirectory()) {
                //过滤当前目录"."和上一级目录".."，防止死循环
                if (!".".equals(file.getName()) && !"..".equals(file.getName())) {
                    listFiles(ftpClient, path, filePathsArr);
                }
            }
        }
        return filePathsArr;
    }

    /**
     * -删除单个文件
     * @param ftpClient
     * @param ftpPath
     *            -FTP服务器保存目录
     * @param filename
     *            -要删除的文件名称
     * @return
     */
    public boolean deleteFile(FTPClient ftpClient, String ftpPath, String filename) {
        boolean flag = false;
        try {
            logger.info("开始删除文件");
            // 切换FTP目录（切换ftp目录会产生权限问题，则不可与遍历删除并用）
            // ftpClient.changeWorkingDirectory(ftpPath);
            flag = ftpClient.deleteFile(ftpPath + "/" + filename);
            if (flag) {
                logger.info("删除文件成功");
            } else {
                logger.info("删除文件失败");
            }
        } catch (Exception e) {
            logger.info("删除文件失败");
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * -删除文件夹内的所有文件以及空文件夹
     *     -注意：
     *         1.-该方法会删除文件夹内的所有遍历递归文件以及空文件夹
     *         2.-该方法需要叠加效果（第一次删除所有文件，第二次删除文件夹），第二次可等待下一次执行该方法
     *         3.-ftpClient.removeDirectory(ftpPath)的方法对非空文件夹无效
     *         4.-ftpClient.changeWorkingDirectory(ftpPath)，切换ftp目录会产生权限问题，需谨慎使用
     * @param ftpClient
     * @param ftpPath
     *            -ftp路径
     * @return true 表似成功，false 失败
     */
    public boolean deleteDir(FTPClient ftpClient, String ftpPath) {
        boolean flag = false;
        try {
            flag = iterateDelete(ftpClient, ftpPath);
            logger.info("ftp文件删除成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * -遍历删除文件以及空文件夹
     * @param ftpClient
     * @param ftpPath
     * @return true 表似成功，false 失败
     * @throws IOException
     */
    public boolean iterateDelete(FTPClient ftpClient, String ftpPath) throws IOException {
        FTPFile[] files = ftpClient.listFiles(ftpPath);
        boolean flag = false;
        for (FTPFile f : files) {
            String path = ftpPath + "/" + f.getName();
            FTPFile[] filesTem = ftpClient.listFiles(path);
            if (f.isDirectory() && filesTem.length == 0) {//空文件夹不再进入递归
                boolean bool = ftpClient.removeDirectory(path);
                logger.info("删除空文件夹：" + bool + " " + path);
            } else if (f.isDirectory() && filesTem.length > 0) {//非空文件夹进入递归
                iterateDelete(ftpClient, path);
            } else {//文件直接删除
                deleteFile(ftpClient, ftpPath, f.getName());
            }
        }
        //删除空文件夹
        if (files.length == 0) {
            flag = ftpClient.removeDirectory(ftpPath);
        } else {
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        FtpUtils ftp = new FtpUtils();
        FTPClient ftpClient = ftp.initFtpClient();
        try {
            /**
             * -上传文件
             */
            // 使用流上传
            // FileInputStream inputStream = new FileInputStream(new File("D:\\sixmonth\\test.txt"));
            // ftp.uploadFile(ftpClient,"sixmonth", "test.txt", inputStream);
            // 使用文件上传，同时测试多层目录
            // ftp.uploadFile(ftpClient, "sixmonth/test", "test.txt", "D:\\sixmonth\\test.txt");
            // ftp.uploadFile(ftpClient,"sixmonth/test3", "test.txt", "D:\\sixmonth\\test.txt");

            /**
             * -下载文件
             */
            // ftp.downloadFile("sixmonth/test", "test.txt", "D://");

            /**
             * -删除文件
             */
            // ftp.deleteFile(ftpClient,"sixmonth/test", "test.txt");//删除单个文件
            // ftp.deleteDir(ftpClient,"sixmonth/test");//删除文件夹

            /**
             * -遍历ftp所有文件夹，返回文件路径集合
             */
            List<String> filePathsArr = new ArrayList<String>();
            ftp.listFiles(ftpClient, "sixmonth", filePathsArr);
            logger.info(filePathsArr.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ftpClient != null) {
                try {
                    ftpClient.logout();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if (ftpClient.isConnected()) {
                    try {
                        ftpClient.disconnect();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
