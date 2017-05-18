package com.common.util;

import com.jcraft.jsch.*;
import org.aspectj.util.FileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Lincg on 2017/5/16.
 */
public class SFTPUtil {


    /**
     * 连接sftp服务器
     *
     * @param host 远程主机ip地址
     * @param port sftp连接端口，null 时为默认端口
     * @param user 用户名
     * @param password 密码
     * @return
     * @throws JSchException
     */
    public static Session connect(String host, Integer port, String user, String password) throws JSchException {
        Session session = null;
        try {
            JSch jsch = new JSch();
            if (port != null) {
                session = jsch.getSession(user, host, port.intValue());
            } else {
                session = jsch.getSession(user, host);
            }

            session.setPassword(password);
            //设置第一次登陆的时候提示，可选值:(ask | yes | no)
            session.setConfig("StrictHostKeyChecking", "no");
            //30秒连接超时
            session.connect(30000);
        } catch (JSchException e) {
            e.printStackTrace();
            System.out.println("SFTPUtil 获取连接发生错误");
            throw e;
        }
        return session;
    }


    /**
     * sftp上传文件(夹)
     *
     * @param directory 目标地址
     * @param uploadFile 上传文件
     * @param sftp sftp连接
     *
     * @throws Exception
     */
    public static void upload(String directory, String uploadFile, ChannelSftp sftp) throws Exception {
        File file = new File(uploadFile);
        if (file.exists()) {
            try {
                //因为ChannelSftp无法判断远程Linux主机的文件路径，所以通过这种方式判断
                Vector content = sftp.ls(directory);
                if (content == null) {
                    sftp.mkdir(directory);
                }
            } catch (SftpException e) {
                sftp.mkdir(directory);
            }
            sftp.cd(directory);
            if (file.isFile()) {
                InputStream inputStream = new FileInputStream(file);
                sftp.put(inputStream, new String(file.getName().getBytes(), "UTF-8"));
            } else {
                File[] files = file.listFiles();
                for (File f : files) {
                    String dir = file.getAbsolutePath();
                    if (f.isDirectory()) {
                        String str = dir.substring(dir.lastIndexOf(File.separator));
                        directory = directory + File.separator + str;
                    }
                    upload(directory, dir, sftp);
                }

            }
        }
    }


    /**
     * sftp下载文件（夹）
     *
     * @param srcFile 下载文件完全路径
     * @param saveFile 保存文件路径
     * @param sftp ChannelSftp
     *
     * @throws UnsupportedEncodingException
     */
    public static void download(String srcFile, String saveFile, ChannelSftp sftp) throws UnsupportedEncodingException {

        Vector contents = null;
        try {
            contents = sftp.ls(srcFile);
        } catch (SftpException e) {
            e.printStackTrace();
            System.out.println("ChannelSftp sftp罗列文件错误");
        }

        File file = new File(saveFile);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                System.out.println("创建目录失败");
            }
        }

        if (srcFile.contains(".")) {
            try {
                sftp.get(srcFile, saveFile);
            } catch (SftpException e) {
                e.printStackTrace();
                System.out.println("ChannelSftp sftp下载文件发生错误");
            }
        } else {
            for (Iterator iterator = contents.iterator(); iterator.hasNext();) {
                ChannelSftp.LsEntry obj = (ChannelSftp.LsEntry) iterator.next();
                String filename = new String(obj.getFilename().getBytes(),"UTF-8");
                System.out.println(filename);
                if (!filename.contains(".")) {
                    srcFile += File.separator + filename;
                    saveFile += File.separator + filename;
                } else {
                   String[] arrs = filename.split("\\.");
                   //跳过文件名".."
                   if ((arrs.length) > 0 ) {
                       srcFile += File.separator + filename;
                   } else {
                       continue;
                   }
                }

                download(srcFile, saveFile, sftp);
            }
        }
    }

    public static void main(String[] agrs) {
        ChannelSftp sftp = null;
        Session session = null;
        try {
            session = SFTPUtil.connect("test", null, "test", "test");
            Channel channel = session.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            SFTPUtil.upload("/wwwroot/www", "E:\\test.JPG",sftp);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sftp != null) {
                sftp.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
        }
    }
}
