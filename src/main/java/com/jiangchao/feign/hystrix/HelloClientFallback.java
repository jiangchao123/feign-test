package com.jiangchao.feign.hystrix;

import org.springframework.stereotype.Component;

/**
 * Created by jiangchao08 on 17/4/22.
 */
@Component
public class HelloClientFallback implements HelloClient {

    @Override
    public String getAnswerResult() {
        return "time out time out time out time out time out time out time out time out ~~~~~~~~~~";
    }
}
