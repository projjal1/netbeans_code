package spring_jdbc_proj;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring_Jdbc_Proj 
{
    public static void main(String[] args) 
    {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");        
        EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");
    
        int status=dao.updateEmployee(new Employee(3,"Sonoo","Mumbai")); 
        System.out.println(status); 
        
        System.out.println("Now select and list all persons");
        List<Employee> list = dao.selectAll();
        for (Employee obj : list) 
        {
            System.out.print("Name: "+obj.getName() + " ");
            System.out.println(", Address: "+obj.getAddress());
        }               
    }    
}
