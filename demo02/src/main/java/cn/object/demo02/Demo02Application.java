package cn.object.demo02;

import org.apache.hadoop.fs.FileSystem;

//import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Demo02Application {
	private static FileSystem hdfs;

	public static void main(String[] args) throws IOException {
		HDFS_INIT.init();

		SpringApplication.run(Demo02Application.class, args);
	}

}
