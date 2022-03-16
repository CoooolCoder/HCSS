package cn.object.demo02;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HDFS_INIT {
    public static FileSystem hdfs;
    public static List<String> hdfsDirectories = new ArrayList<>();

    public static void init() throws IOException {
        System.out.println("-----------hdfs-starting---------");
        // 1.创建配置器
        Configuration conf = new Configuration();

        // 2.取得FileSystem文件系统 实例
        conf.set("fs.defaultFS","hdfs://centos01:9000");

        // 3.创建可供hadoop使用的文件系统路径
        hdfs = FileSystem.get(conf);
        System.out.println("------------hdfs-running--------");
    }

//    public static void






}
