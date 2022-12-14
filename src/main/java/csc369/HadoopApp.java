package csc369;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class HadoopApp {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "Hadoop example");
        String[] otherArgs = new GenericOptionsParser(conf, args).getRemainingArgs();

	if (otherArgs.length < 3) {
	    System.out.println("Expected parameters: <job class> <input dir> <output dir>");
	    System.exit(-1);
	} else if ("WordCount".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(WordCount.ReducerImpl.class);
	    job.setMapperClass(WordCount.MapperImpl.class);
	    job.setOutputKeyClass(WordCount.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(WordCount.OUTPUT_VALUE_CLASS);
	} else if ("AccessLog".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(AccessLog.ReducerImpl.class);
	    job.setMapperClass(AccessLog.MapperImpl.class);
	    job.setOutputKeyClass(AccessLog.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(AccessLog.OUTPUT_VALUE_CLASS);
        } else if ("AccessLog2".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(AccessLog2.ReducerImpl.class);
	    job.setMapperClass(AccessLog2.MapperImpl.class);
	    job.setOutputKeyClass(AccessLog2.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(AccessLog2.OUTPUT_VALUE_CLASS);
	} else if ("Report01".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(Report01.ReducerImpl.class);
	    job.setMapperClass(Report01.MapperImpl.class);
	    job.setOutputKeyClass(Report01.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(Report01.OUTPUT_VALUE_CLASS);
	} else if ("Report02".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(Report02.ReducerImpl.class);
	    job.setMapperClass(Report02.MapperImpl.class);
	    job.setOutputKeyClass(Report02.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(Report02.OUTPUT_VALUE_CLASS);
	} else if ("Report03".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(Report03.ReducerImpl.class);
	    job.setMapperClass(Report03.MapperImpl.class);
	    job.setOutputKeyClass(Report03.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(Report03.OUTPUT_VALUE_CLASS);
	} else if ("Report04".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(Report04.ReducerImpl.class);
	    job.setMapperClass(Report04.MapperImpl.class);
	    job.setOutputKeyClass(Report04.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(Report04.OUTPUT_VALUE_CLASS);
	} else if ("Report05".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(Report05.ReducerImpl.class);
	    job.setMapperClass(Report05.MapperImpl.class);
	    job.setOutputKeyClass(Report05.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(Report05.OUTPUT_VALUE_CLASS);
	} else if ("Report06".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(Report06.ReducerImpl.class);
	    job.setMapperClass(Report06.MapperImpl.class);
	    job.setOutputKeyClass(Report06.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(Report06.OUTPUT_VALUE_CLASS);
	} else if ("SortKeysByASCValue".equalsIgnoreCase(otherArgs[0])) {
	    job.setReducerClass(SortKeysByASCValue.ReducerImpl.class);
	    job.setMapperClass(SortKeysByASCValue.MapperImpl.class);
	    job.setOutputKeyClass(SortKeysByASCValue.OUTPUT_KEY_CLASS);
	    job.setOutputValueClass(SortKeysByASCValue.OUTPUT_VALUE_CLASS);
	} else {
	    System.out.println("Unrecognized job: " + otherArgs[0]);
	    System.exit(-1);
	}

        FileInputFormat.addInputPath(job, new Path(otherArgs[1]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[2]));

        System.exit(job.waitForCompletion(true) ? 0: 1);
    }

}
