package cn.object.demo02.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Component
public class HDFSREQUEST {
    private String source;
    private String destination;
    private String content;

}
