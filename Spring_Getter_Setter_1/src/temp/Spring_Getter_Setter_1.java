package temp;

import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.core.io.*;  

public class Spring_Getter_Setter_1 
{
    public static void main(String[] args) 
    {
        Resource r=new ClassPathResource("applicationContext.xml");  
        BeanFactory factory=new XmlBeanFactory(r);  
          
        Employee e=(Employee)factory.getBean("obj");  
        e.display();  
    }
}
