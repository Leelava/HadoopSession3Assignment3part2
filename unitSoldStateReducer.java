package UnitSoldState;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;

public class unitSoldStateReducer extends Reducer<Text,Text,Text,IntWritable>
{
	
	public void reduce(Text key,Iterable<Text> values,Context context)
			throws IOException, InterruptedException
	{
			int sum = 0;
			
			for(Text value: values)
				{ 
					if (value.toString()!= null){
						sum = sum+1;
					}
					
				}
		context.write(key, new IntWritable(sum));				
				
	}
}