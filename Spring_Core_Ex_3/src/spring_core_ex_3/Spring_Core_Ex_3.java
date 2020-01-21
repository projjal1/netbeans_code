package spring_core_ex_3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Spring_Core_Ex_3 
{
    public static void main(String[] args) 
    {
        Resource r=new ClassPathResource("applicationContext.xml");
        BeanFactory b=new XmlBeanFactory(r);
        Pojo e=(Pojo)b.getBean("obj");
        
        e.disp(e);
    }    
}
