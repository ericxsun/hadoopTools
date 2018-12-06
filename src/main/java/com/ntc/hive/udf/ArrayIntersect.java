package com.ntc.hive.udf;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Copyright @2018 R&D, NTC Inc. (ntc.com)
 *
 * Author: Eric x.sun <eric.x.sun@gmail.com>
 */


@Description(name = "arrayIntersect",
    value = "_FUNC_(values) - Computes the intersection of the array arguments.  Note that ordering will be lost.")
public class ArrayIntersect extends UDF {
    public ArrayList<Text> evaluate(ArrayList<Text>... arrays) {
        HashSet<Text> result_set = null;

        for(ArrayList<Text> arr: arrays) {
            if (arr == null) {
                continue;
            }

            if (result_set == null) {
                result_set = new HashSet<>(arr);
            } else {
                result_set.retainAll(arr);
            }
        }

        if (result_set != null) {
            return new ArrayList<>(result_set);
        } else {
            return new ArrayList<>();
        }
    }
}