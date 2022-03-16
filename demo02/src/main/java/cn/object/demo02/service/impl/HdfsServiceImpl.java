package cn.object.demo02.service.impl;
import cn.object.demo02.domain.HDFSREQUEST;
import cn.object.demo02.service.HdfsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static cn.object.demo02.HDFS_INIT.hdfs;
import static cn.object.demo02.HDFS_INIT.hdfsDirectories;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service

public class HdfsServiceImpl implements HdfsService {

    private String source;
    private String destination;

    HdfsServiceImpl(HDFSREQUEST hdfsrequest){
        source = hdfsrequest.getSource();
        destination = hdfsrequest.getDestination();
    }

    public void createFile(HDFSREQUEST hdfsrequest) throws Exception {

        FSDataOutputStream outputStream = hdfs.create(new Path(hdfsrequest.getDestination())); // Files are overwritten by default
        outputStream.write(hdfsrequest.getContent().getBytes()); // enter the content
        outputStream.close();
        System.out.println("mkdir is done!");
    }

    public boolean deleteFile(HDFSREQUEST hdfsrequest) throws Exception {

        Path path = new Path(hdfsrequest.getDestination());
        boolean isok = hdfs.deleteOnExit(path);
        if (isok) {
            System.out.println(hdfsrequest.getDestination()+"删除成功!");
        } else {
            System.out.println("删除失败！");
        }
//        hdfs.close();
        return isok;
    }

    public List<String> showRoot() throws IOException {
        hdfsDirectories.clear();
        FileStatus fs = hdfs.getFileStatus(new Path("hdfs:/"));

        showDir(fs);

        return hdfsDirectories;
    }

    public void showDir(FileStatus fileStatus) throws IOException {

        Path path = fileStatus.getPath();
        hdfsDirectories.add(path.toString());

        if(fileStatus.isDirectory()){
            FileStatus[] f = hdfs.listStatus(path);
            if(f.length > 0)
                for(FileStatus file : f)
                    showDir(file);
        }
    }

    // 复制上传本地文件
    public void copyFromLocalFile(HDFSREQUEST hdfsrequest) throws Exception {

        Path src = new Path(hdfsrequest.getSource()); // 本地目录/文件
        Path dst = new Path(hdfsrequest.getDestination()); // 目标目录/文件
        //拷贝上传本地文件（本地文件，目标路径） 至HDFS文件系统中
        hdfs.copyFromLocalFile(src, dst);
        System.out.println("upload successful!");
    }

    public void copyToLocalFile(HDFSREQUEST hdfsrequest) throws Exception {
        Path src = new Path(hdfsrequest.getSource());
        Path dst = new Path(hdfsrequest.getDestination()); // 本地目录/文件
        //从HDFS文件系统中拷贝下载文件（目标路径，本地文件）至本地
//        hdfs.copyToLocalFile(src, dst);
        hdfs.copyToLocalFile(false, src, dst, true);//delSrc – whether to delete the src
        System.out.println("文件下载成功!");
    }

}
