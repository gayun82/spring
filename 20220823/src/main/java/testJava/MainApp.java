package testJava;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("applicationContext.xml");
				//컨테이너 구축 빈객체에 다 올라감
		
//		TV tv2 = (TV) context.getBean("samsungTV");
//		tv2.powerOn();
//		tv2.powerOff();
//		tv2.volumeUp();
//		tv2.volumeDown();
		
		LgTV tv = (LgTV) context.getBean("lgTV");
		tv.getTv().powerOff();	
		
		//LgTV tv1 = new LgTV((TV) context.getBean("samsungTV"));
	}

}
