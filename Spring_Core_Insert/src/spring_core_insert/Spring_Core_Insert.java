
package spring_core_insert;

import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
public class Spring_Core_Insert {  
  
public static void main(String[] args) {  
    ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");  
          
    StudentDao dao=(StudentDao)ctx.getBean("edao");  
    dao.saveEmployeeByPreparedStatement(new Student("Amit","234","a@gmail.com","India"));  
}  
}  