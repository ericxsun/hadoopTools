# Hadoop/Hive Common Tools

Common tools used in Hadoop or Hive.

- ParseJsonWithPath
    - hive UDF: parse json with given xpath. 
    
    - A third-party [JsonPath](https://github.com/jayway/JsonPath) is used. Thanks a lot.
    
    - usage: 

    ```shell
    ADD JAR your-path/[ParseJsonWithPath.jar](https://github.com/followyourheart/hadoopTools/blob/master/out/artifacts/ParseJsonWithPath.jar);
        CREATE TEMPORARY FUNCTION parseJsonWithPath AS 'com.ntc.hive.udf.ParseJsonWithPath';
     ```

    - more usage: see [JsonPath](https://github.com/jay