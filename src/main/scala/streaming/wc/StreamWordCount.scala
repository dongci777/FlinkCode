package streaming.wc

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.scala._

/**
 * @Author: zxb
 * @Date : 2020/12/21 10:57 下午
 */
object StreamWordCount {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val inputDataStream: DataStream[String] = env.socketTextStream("localhost", 7777)
    val wordCountStream: DataStream[(String, Int)] = inputDataStream.flatMap(_.split(" "))
      .filter(_.nonEmpty)
      .map((_, 1))
      .keyBy(0)
      .sum(1)
    wordCountStream.print()
    env.execute("stream word count")
  }
}
