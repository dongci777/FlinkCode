package streaming.beans;

/**
 * @Author: zxb
 * @Date : 2021/1/4 11:33 下午
 */
public class SensorReading {
    private String id;
    private Long timestamp;
    private Double temprature;

    public SensorReading() {
    }

    public SensorReading(String id, Long timestamp, Double temprature) {
        this.id = id;
        this.timestamp = timestamp;
        this.temprature = temprature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTemprature() {
        return temprature;
    }

    public void setTemprature(Double temprature) {
        this.temprature = temprature;
    }

    @Override
    public String toString() {
        return "SensorReading{" +
                "id='" + id + '\'' +
                ", timestamp=" + timestamp +
                ", temprature=" + temprature +
                '}';
    }
}
