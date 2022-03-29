package org.ergemp.training.spark.rdd.IO;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class ReadCouchbaseExample {
    public static void main(String[] args) {
        Logger.getLogger("org").setLevel(Level.ERROR);
        Logger.getLogger("akka").setLevel(Level.OFF);

        SparkConf conf = new SparkConf().setAppName("ReadCouchbaseExample").setMaster("local[1]");
        JavaSparkContext jsc = new JavaSparkContext(conf);



    }
}
