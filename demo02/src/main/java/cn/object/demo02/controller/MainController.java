package cn.object.demo02.controller;

import cn.object.demo02.domain.HDFSREQUEST;
import cn.object.demo02.service.HdfsService;
import cn.object.demo02.service.impl.HdfsServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

//Restful风格
@RestController
@RequestMapping(value = "/hdfs"/*,method = RequestMethod.GET*/)
public class MainController {

    @Resource
    HdfsServiceImpl hdfsServiceImpl;

    @GetMapping
    public String get(){
        System.out.println("Springboot is running");

        return "Springboot and hdfs is running";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public String delete(@RequestBody HDFSREQUEST hdfsrequest) throws Exception{
        System.out.println(hdfsrequest.getDestination());
        boolean isOk = false;
        isOk = hdfsServiceImpl.deleteFile(hdfsrequest);
        if(isOk)
            return "done";
        else
            return "failure";
    }

    @RequestMapping(value = "/download",method = RequestMethod.PUT)
    public String download(@RequestBody HDFSREQUEST hdfsrequest) throws Exception{
        System.out.println(hdfsrequest.getSource()+"\n"+hdfsrequest.getDestination());

        hdfsServiceImpl.copyToLocalFile(hdfsrequest);

        return "done";
    }


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestBody HDFSREQUEST hdfsrequest) throws Exception {
        System.out.println(hdfsrequest.getSource()+"\n"+hdfsrequest.getDestination());

        hdfsServiceImpl.copyFromLocalFile(hdfsrequest);

        return "done";
    }

    @RequestMapping(value = "/mkdir",method = RequestMethod.POST)
    public String mkdir(@RequestBody HDFSREQUEST hdfsrequest) throws Exception {
        System.out.println(hdfsrequest.getDestination());

        hdfsServiceImpl.createFile(hdfsrequest);

        return "done";

    }


    @RequestMapping(value = "/getRootDirectory",method = RequestMethod.GET)
    public List<String> getDirectory() throws IOException {
        return hdfsServiceImpl.showRoot();

    }

    @RequestMapping(value = "/{str}",method = RequestMethod.DELETE)
    public String delete(@PathVariable String str){
        System.out.println(str);
        return str;
    }



}
