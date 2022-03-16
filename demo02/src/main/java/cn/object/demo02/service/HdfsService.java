package cn.object.demo02.service;


import cn.object.demo02.domain.HDFSREQUEST;
import org.apache.hadoop.fs.FileStatus;

import java.io.IOException;
import java.util.List;

public interface HdfsService {

    void createFile(HDFSREQUEST hdfsrequest) throws Exception;

    boolean deleteFile(HDFSREQUEST hdfsrequest) throws Exception;

    List<String> showRoot() throws IOException;

    void showDir(FileStatus fileStatus) throws IOException;

    // 复制上传本地文件
    void copyFromLocalFile(HDFSREQUEST hdfsrequest) throws Exception;

    void copyToLocalFile(HDFSREQUEST hdfsrequest) throws Exception;

}
