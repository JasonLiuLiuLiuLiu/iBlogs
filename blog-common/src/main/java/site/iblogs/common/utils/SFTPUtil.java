package site.iblogs.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import site.iblogs.common.model.BoolResultWithMessage;

public class SFTPUtil {

    /**
     * 连接sftp服务器
     */
    private static ChannelSftp login(String host, int port, String username, String password) throws JSchException {
            JSch jsch = new JSch();
            Session session = jsch.getSession(username, host, port);
            if (password != null) {
                session.setPassword(password);
            }
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            Channel channel = session.openChannel("sftp");
            channel.connect();
            return (ChannelSftp) channel;
    }

    /**
     * 关闭连接 server
     */
    private static void logout(ChannelSftp sftp) {
        Session session=null;
        try {
            if (sftp != null) {
                session=sftp.getSession();
                if (sftp.isConnected()) {
                    sftp.disconnect();
                }
            }
            if (session != null) {
                if (session.isConnected()) {
                    session.disconnect();
                }
            }
        }catch (JSchException ex){
            ex.printStackTrace();
        }

    }

    /**
     * 将输入流的数据上传到sftp作为文件。文件完整路径=basePath+directory
     */
    public static BoolResultWithMessage upload(String host, int port, String username, String password, String directory, String sftpFileName, String localPath){
        BoolResultWithMessage result=new BoolResultWithMessage();
        ChannelSftp sftp=null;
        try {
            sftp=login(host,port,username,password);
            sftp.cd(directory);
            File file=new File(localPath);
            sftp.put(new FileInputStream(file), sftpFileName); // 上传文件
            result.setSuccess(true);
        } catch (Exception ex) {
           result.setMessage(ex.getMessage());
           result.setSuccess(false);
        }finally {
            logout(sftp);
        }
        return result;
    }

}