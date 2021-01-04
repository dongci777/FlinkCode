package batch.wc

import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}
import org.apache.flink.api.scala._

/**
 * @Author: zxb
 * @Date : 2020/12/21 10:32 下午
 */
object WordCount {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val inputDS: DataSet[String] = env.readTextFile("data/wc/wordcount.txt")
    val wordCountDS = inputDS.flatMap(_.split(" ")).map((_, 1)).groupBy(0).sum(1)
    wordCountDS.print()
  }
}
