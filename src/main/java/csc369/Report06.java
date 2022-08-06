package csc369;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

import java.util.HashMap;

public class Report06 {

    public static final Class OUTPUT_KEY_CLASS = Text.class;
    public static final Class OUTPUT_VALUE_CLASS = IntWritable.class;

    public static class MapperImpl extends Mapper<LongWritable, Text, Text, IntWritable> {
	private final IntWritable one = new IntWritable(1);
	private Text word = new Text();

        @Override
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		HashMap<String, String> map = new HashMap<>();
		map.put("Jan", "01");
		map.put("Feb", "02");
		map.put("Mar", "03");
		map.put("Apr", "04");
		map.put("May", "05");
		map.put("Jun", "06");
		map.put("Jul", "07");
		map.put("Aug", "08");
		map.put("Sep", "09");
		map.put("Oct", "10");
		map.put("Nov", "11");
		map.put("Dec", "12");
		
		String[] tokens = value.toString().split(" ");
		String dateToken = tokens[3];
		String[] dateTokens = dateToken.split("/|:");
		String day = dateTokens[0].replaceAll("\\[", "");
		String month = map.get(dateTokens[1]);
		String year = dateTokens[2];
		
		word.set(year + "-" + month + "-" + day);
		context.write(word, one);
        }
    }

    public static class ReducerImpl extends Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable result = new IntWritable();
    
        @Override
	protected void reduce(Text key, Iterable<IntWritable> intOne, Context context) throws IOException, InterruptedException {
		HashMap<String, String> map = new HashMap<>();
		map.put("01", "Jan");
		map.put("02", "Feb");
		map.put("03", "Mar");
		map.put("04", "Apr");
		map.put("05", "May");
		map.put("06", "Jun");
		map.put("07", "Jul");
		map.put("08", "Aug");
		map.put("09", "Sep");
		map.put("10", "Oct");
		map.put("11", "Nov");
		map.put("12", "Dec");
		
		String[] tokens = key.toString().split("-");
		
		Text word = new Text();
		word.set(tokens[2] + "-" + map.get(tokens[1]) + "-" + tokens[0]);
		
		
            	int sum = 0;
            	Iterator<IntWritable> itr = intOne.iterator();
        
            	while (itr.hasNext()) {
               		sum  += itr.next().get();
            	}
            	result.set(sum);
            	context.write(word, result);
       }
    }
}
