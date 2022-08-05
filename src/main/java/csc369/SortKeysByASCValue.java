package csc369;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class SortKeysByASCValue {

    public static final Class OUTPUT_KEY_CLASS = Text.class;
    public static final Class OUTPUT_VALUE_CLASS = IntWritable.class;

    public static class MapperImpl extends Mapper<Text, IntWritable, IntWritable, Text> {
	private final IntWritable one = new IntWritable(1);
	private Text word = new Text();

        @Override
	protected void map(Text key, IntWritable value, Context context) throws IOException, InterruptedException {
		context.write(value, key);
		//word.set(key.toString());
		//context.write(Integer.parseInt(value.toString()), word);
		/*
            StringTokenizer itr = new StringTokenizer(value.toString());
	          word.set(itr.nextToken());  // ignore whitespace and punctuation
            context.write(new IntWritable(Integer.parseInt(value.toString())), word);
	    */
        }
    }

    public static class ReducerImpl extends Reducer<IntWritable, Text, Text, IntWritable> {
	private IntWritable result = new IntWritable();
    
        @Override
	protected void reduce(IntWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {        
            for (Text value : values) {
              //result.set(key.get());
              context.write(value, key);
            }
            
       }
    }

}
