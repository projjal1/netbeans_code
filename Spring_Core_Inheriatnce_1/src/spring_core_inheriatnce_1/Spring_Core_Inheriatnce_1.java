
package spring_core_inheriatnce_1;

import org.springframework.beans.factory.BeanFactory;  
import org.springframework.beans.factory.xml.XmlBeanFactory;  
import org.springframework.core.io.ClassPathResource;  
import org.springframework.core.io.Resource;  
public class Spring_Core_Inheriatnce_1 
{

   
    public static void main(String[] args)
    {
         Resource r=new ClassPathResource("applicationContext.xml");  
    BeanFactory factory=new XmlBeanFactory(r);  
      
    Employee e1=(Employee)factory.getBean("e2");  
    e1.show();  
    }
}
