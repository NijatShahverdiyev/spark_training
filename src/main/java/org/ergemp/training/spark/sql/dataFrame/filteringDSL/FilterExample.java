package org.ergemp.training.spark.sql.dataFrame.filteringDSL;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;

public class FilterExample {
    public static void main(String[] args){
        Logger log = Logger.getRootLogger();
        log.setLevel(Level.ERROR);

        Logger.getLogger("org").setLevel(Level.ERROR);
        Logger.getLogger("akka").setLevel(Level.OFF);

        // configure spark
        SparkSession spark = SparkSession
                .builder()
                .appName("FilterExample")
                .master("local")
                .getOrCreate();

        // read list to RDD
        String jsonPath = "resources/mock_clickStream.json";
        Dataset<Row> df = spark.read().json(jsonPath);

        df.printSchema();
        df.show(false);

        df.filter(col("event").equalTo("newSession")).show();
        df.filter(col("ip_address").like("2%")).show();
    }
}
