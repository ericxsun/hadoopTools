package com.ntc.hive.udf;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.hive.ql.exec.UDFArgumentException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyler.li on 2015/12/3.
 */
@Description(
        name = "seq",
        value = "Return a list of numbers from FIRST to LAST, in steps of INCREMENT."
)
public class SeqUDF extends UDF {
    public List<Integer> evaluate(Object lastText) throws UDFArgumentException {
        int first = 1;
        int last = Integer.valueOf(lastText.toString());
        int step = first <= last ? 1 : -1;
        return process(first, last, step);
    }

    public List<Integer> evaluate(Object firstText, Object lastText) throws UDFArgumentException {
        int start = Integer.valueOf(firstText.toString());
        int last = Integer.valueOf(lastText.toString());
        int step = start <= last ? 1 : -1;
        return process(start, step, last);
    }

    public List<Integer> evaluate(Object firstText, int step, Object lastText) throws UDFArgumentException {
        int first = Integer.valueOf(firstText.toString());
        int last = Integer.valueOf(lastText.toString());
        return process(first, step, last);
    }

    private List<Integer> process(int first, int step, int last) {
        List<Integer> list = new ArrayList<Integer>();
        /*step不能为0*/
        if (step == 0) {
            return list;
        }
        int i;
        if (last >= first) {
            /*step正负与序列方向不一致时进行调整*/
            if (step < 1) {
                step = -step;
            }
            for (i = first; i <= last; i += step) {
                list.add(i);
            }
        } else {
            if (step > 1) {
                step = -step;
            }
            for (i = first; i >= last; i += step) {
                list.add(i);
            }

        }
        return list;
    }

}
