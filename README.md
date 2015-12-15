# Hadoop/Hive Common Tools

Common tools used in Hadoop or Hive.

- Test Env:
  - Hadoop: 2.6.0-cdh5.5.0
  - Hive: 1.1.0-cdh5.5.0

- [ParseJsonWithPath](https://github.com/followyourheart/hadoopTools/raw/master/out/artifacts/ParseJsonWithPath.jar)
    - hive UDF: parse json with given xpath. 
    
    - A third-party [JsonPath](https://github.com/jayway/JsonPath) is used. Thanks a lot.
    
    - usage: 

    ```shell
    ADD JAR your-path/ParseJsonWithPath.jar;
    CREATE TEMPORARY FUNCTION parseJsonWithPath AS 'com.ntc.hive.udf.ParseJsonWithPath';
     ```

    - more usage: see [JsonPath](https://github.com/jayway/JsonPath)