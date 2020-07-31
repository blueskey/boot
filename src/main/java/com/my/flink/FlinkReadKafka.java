package com.my.flink;

import com.google.common.collect.Lists;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.AllWindowFunction;
import org.apache.flink.streaming.api.windowing.time.Time;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FlinkReadKafka {

    public static void main(String[] args) {

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaUtil.broker_list+":9092");
        props.put("zookeeper.connect", KafkaUtil.broker_list+":2181");
        props.put("group.id", "metric-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "latest");

        SingleOutputStreamOperator<String> log = env.addSource(new FlinkKafkaConsumer011<>(
                KafkaUtil.topic,   //这个 kafka topic 需要和上面的工具类的 topic 一致
                new SimpleStringSchema(),
                props)).setParallelism(1)
                .map(string -> string
                );

        log.timeWindowAll(Time.minutes(1)).apply(new AllWindowFunction<String, List<String>, TimeWindow>() {
            @Override
            public void apply(TimeWindow timeWindow, Iterable<String> values, Collector<List<String>> collector) throws Exception {
                ArrayList<String> logs = Lists.newArrayList(values);
                if (logs.size() > 0) {
                    System.out.println("1 分钟内收集到 student 的数据条数是：" + logs.size());
                    collector.collect(logs);
                }
            }
        }).addSink(new SinkToMySQL());

        try {
            env.execute("flink learning connectors kafka");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
