package streaming.source

import org.apache.flink.streaming.api.scala._

/**
 * @Author: zxb
 * @Date : 2021/1/4 11:27 下午
 */
object SourceTest_Collection {
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

    val inputStream: DataStream[SensorReading] = env.fromCollection(
      List(
        SensorReading("sensor_1", 1547718199, 35.8),
        SensorReading("sensor_6", 1547718201, 15.4),
        SensorReading("sensor_7", 1547718202, 6.7),
        SensorReading("sensor_10", 1547718205, 38.1)
      ))
    inputStream.print("inputStream:").setParallelism(1)
    env.execute("Source from Collection")
  }

}

case class SensorReading(id: String, timestamp: Long, temprature: Double)
