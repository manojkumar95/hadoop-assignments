import java.io.BufferedOutputStream;
 
import java.io.FileOutputStream;
 
import java.io.InputStream;
 
import java.io.OutputStream;
 
import org.apache.hadoop.conf.Configuration;
 
import org.apache.hadoop.conf.Configured;
 
import org.apache.hadoop.fs.FileSystem;
 
import org.apache.hadoop.fs.Path;
 
import org.apache.hadoop.io.IOUtils;
 
import org.apache.hadoop.util.Tool;
 
import org.apache.hadoop.util.ToolRunner;
 
public class HdfsReader extends Configured implements Tool {
 
public int run(String[] args) throws Exception {
 
String localOutputPath = args[0];
 
Configuration conf = getConf();
 
FileSystem fs = FileSystem.get(conf);
 
InputStream is = fs.open(new Path("hdfs:/user/acadgild/sample.txt"));
 
OutputStream os = new BufferedOutputStream(new FileOutputStream(localOutputPath)); // Data set is getting copied into local path in the file sysetm through buffer mechanism
 
IOUtils.copyBytes(is, os, conf);
 
return 0;
 
}
 
public static void main(String[] args) throws Exception {
 
int returnCode = ToolRunner.run(
 
new HdfsReader(), args);
 
System.exit(returnCode);
 
}
 
}