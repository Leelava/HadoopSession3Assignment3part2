package UnitSoldState;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class unitSoldStateMapper extends Mapper <LongWritable,Text,Text,Text>{
public void map(LongWritable key,Text Value,Context context)
throws IOException,InterruptedException
{ if(Value.toString().split("|")!= null)
			{
	String[] lineArray = Value.toString().split("\\|");
	boolean invalidCompanyName=lineArray[0].equals("NA");
	boolean invalidProductname =lineArray[1].equals("NA");
			
if ((!(invalidCompanyName) )&& (!(invalidProductname)))
{  if(lineArray[0].equals("Onida"))
			
			{
	         Text productName = new Text(lineArray[1]);
             Text State =new Text(lineArray[3]);
			
			context.write(State,productName);}}
			
}
			
}			
}
