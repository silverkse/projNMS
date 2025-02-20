package com.nms.nms_gateway.AWSLamda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class NmsGatewayHandler implements RequestHandler<String, String> {

    @Override
    public String handleRequest(String input, Context context) {
        context.getLogger().log("람다 실행됨: 입력값 = " + input);
        return "Lambda 실행 성공: " + input;
    }
}
