import java.io.BufferedInputStream;
 
import java.io.FileInputStream;
 
import java.io.InputStream;
 
import java.io.OutputStream;
 
import org.apache.hadoop.conf.Configuration;
 
import org.apache.hadoop.conf.Configured;
 
import org.apache.hadoop.fs.FileSystem;
 
import org.apache.hadoop.fs.Path;
 
import org.apache.hadoop.io.IOUtils;
 
import org.apache.hadoop.util.Tool;
 
import org.apache.hadoop.util.ToolRunner;
 
public class HdfsWriter extends Configured implements Tool {
 
public int run(String[] args) throws Exception {
 
//String localInputPath = args[0];
 
Path outputPath = new Path(args[0]);// ARGUMENT FOR OUTPUT_LOCATION
 
Configuration conf = getConf();
 
FileSystem fs = FileSystem.get(conf);
 
OutputStream os = fs.create(outputPath);
 
InputStream is = new BufferedInputStream(new FileInputStream("/home/acadgild/sample.txt"));
IOUtils.copyBytes(is, os, conf); // Copying the dataset from input stream to output stream
 
return 0;
 
}
 
public static void main(String[] args) throws Exception {
 
int returnCode = ToolRunner.run(new HdfsWriter(), args);
 
System.exit(returnCode);
 
}
 