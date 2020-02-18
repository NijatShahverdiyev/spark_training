package org.ergemp.training.spark.streaming.transformation;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public class ForEachRDDExample1 {
    public static void main(String[] args){
        Logger log = Logger.getRootLogger();
        log.setLevel(Level.ERROR);

        Logger.getLogger("org").setLevel(Level.ERROR);
        Logger.getLogger("akka").setLevel(Level.OFF);

        SparkConf conf = new SparkConf()
                .setAppName("ForEachRDDExample1")
                .setMaster("local[2]");

        JavaStreamingContext jssc = new JavaStreamingContext(conf, new Duration(10000));
        JavaDStream<String> lines = jssc.socketTextStream("localhost", 19999);


        lines.foreachRDD(rdd -> {
                    System.out.println("Size of the RDD: " + rdd.collect().size());
                }
                );

        try {
            jssc.start();
            jssc.awaitTermination();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
