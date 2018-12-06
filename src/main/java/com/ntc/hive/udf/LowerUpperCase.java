package com.ntc.hive.udf;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

import java.util.ArrayList;

/**
 * Copyright @2018 R&D, NTC Inc. (ntc.com)
 *
 * Author: Eric x.sun <eric.x.sun@gmail.com>
 */


@Description(name = "lowerUpperCase", value = "_FUNC_(values, isLower) - lower or upper the elements.")
public class LowerUpperCase extends UDF {
    public ArrayList<String> evaluate(ArrayList<String> words, Boolean isLower) {
        ArrayList<String> casedWords = new ArrayList<>();

        for (String w: words) {
            if (isLower) {
                casedWords.add(w.toLowerCase());
            } else {
                casedWords.add(w.toUpperCase());
            }
        }

        return casedWords;
    }
}