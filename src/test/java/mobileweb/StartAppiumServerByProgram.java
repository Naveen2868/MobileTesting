package mobileweb;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StartAppiumServerByProgram {

	
	String nodepath = "C:\\Program Files\\nodejs\\node.exe";
	String appiumjspath="C:\\Users\\naleti\\AppData\\Local\\Programs\\Appium\\resources\\app\node_modules\\appium\\"
			+ "build\\lib";
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-DD HH:mm:ss.SSS");
	
	
	@BeforeTest
	public void startAppiumServer() throws ExecuteException, IOException, InterruptedException{
		CommandLine c= new CommandLine("cmd");
		c.addArgument("/c");
		c.addArgument("nodepath");
		c.addArgument("appiumjspath");
		c.addArgument("--adress",false);
		c.addArgument("127.0.0.1");
		c.addArgument("--port",false);
		c.addArgument("4724");
		c.addArgument("--full-reset",false);
		c.addArgument("--log-level",true);
		
		DefaultExecuteResultHandler rh = new DefaultExecuteResultHandler();
		DefaultExecutor exe = new DefaultExecutor();
		exe.setExitValue(1);
		exe.execute(c,rh);
		System.out.println("starting the server ..."+"\n"+df.format(new Date()));
		Thread.sleep(10000);
	}
	
	@Test
	public void test1() {
		System.out.println("dummy test");
	}
	
	@AfterTest
	public void killAppiumServer() throws ExecuteException, IOException{
		CommandLine c= new CommandLine("cmd");
		c.addArgument("/c");
		c.addArgument("Taskkill /F /IM node.exe");
		
		DefaultExecuteResultHandler rh = new DefaultExecuteResultHandler();
		DefaultExecutor exe = new DefaultExecutor();
		exe.setExitValue(1);
		exe.execute(c,rh);
		System.out.println("stopping the server ..."+"\n"+df.format(new Date()));
	}
	
	

}
