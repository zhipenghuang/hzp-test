import com.springmvc.model.ChatBackground;
import com.springmvc.model.Localtion;
import com.springmvc.service.MyService;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration({"classpath*:spring-mybatis.xml"})
public class MyTest {
	
	@Autowired
    private MyService myService ;
	
	@Test
	public void myTest(){
		List<Localtion> all = myService.findAll(0L);
		for (int i = 0; i <all.size() ; i++) {
			System.out.println(all.get(i).toString()+"------------------------");
		}                                                    
	}
	
	@Test
	public void myTest1() throws ParseException{
		DateTimeFormatter format = DateTimeFormat .forPattern("yyyy-MM-dd HH:mm:ss");  
		DateTime dateTime2 = DateTime.parse("2012-12-21 23:22:45", format);    
		DateTime dt1 = new DateTime();
		DateTime dt2 = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss").parseDateTime("2012-12-26 03:27:39");  
		System.err.println(dt2.toString("yyyy-MM-dd HH:mm:ss"));
		
	}
	
}
