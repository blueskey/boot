package com.my.flink;

import org.apache.flink.streaming.api.functions.sink.SinkFunction;

import java.util.List;

public class SinkToMySQL implements SinkFunction<List<String>> {

    @Override
    public void invoke(List<String> value, Context context) throws Exception {
        System.out.println("写入mysql:"+value);

    }
}
