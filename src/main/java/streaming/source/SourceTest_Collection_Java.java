package streaming.source;

import lombok.val;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Arrays;

/**
 * @Author: zxb
 * @Date : 2021/1/4 11:36 下午
 */
public class SourceTest_Collection_Java {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStreamSource<SensorReading> sensorReadingDataStreamSource = env.fromCollection(Arrays.asList(
                new SensorReading("sensor_1", 1547718199, 35.8),
                new SensorReading("sensor_6", 1547718201, 15.4),
                new SensorReading("sensor_7", 1547718202, 6.7),
                new SensorReading("sensor_10", 1547718205, 38.1))
        );
        val intDataStream = env.fromElements(1, 2, 3, 4, 100, 109);
        // 设置并行度为1保证该stream里面的数据可以顺序输出
        intDataStream.print("intDataStream:").setParallelism(1);
        sensorReadingDataStreamSource.print("sensorReadingDataStreamSource:");
        env.execute("Source from Collection");
    }
}
