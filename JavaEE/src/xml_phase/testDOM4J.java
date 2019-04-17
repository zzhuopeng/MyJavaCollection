package xml_phase;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * 在使用DOM4J前，首先需要导入dom4j-1.6.1\下的dom4j-1.6.1.jar
 * 在使用Xpath前，需要导入dom4j-1.6.1\lib\下的jaxen-1.1-beta-6.jar
 *
 * XML解析
 */
public class testDOM4J {

    public static void main(String[] args) {
        try {
            //1.创建SAX读取对象
            SAXReader saxReader = new SAXReader();
            //2.指定解析的xml源
//            Document document = saxReader.read(new File("xml_phase/Students.xml_phase"));//new File方式不行
            InputStream inputStream = testDOM4J.class.getClassLoader().getResourceAsStream("xml_phase/Students.xml");
            Document document = saxReader.read(inputStream);
            //3.得到根元素
            Element rootElement = document.getRootElement();

            //DOM4J获取子元素
           /* System.out.println(rootElement.element("stu").getName());
            System.out.println(rootElement.element("stu").element("age").getText());
            //获取所有子元素
            List<Element> elements = rootElement.elements();
            for (Element element : elements) {
                String name = element.element("name").getStringValue();
                String age = element.element("age").getText();
                String address = element.element("address").getText();
                System.out.println(name + "+" + age + "+" + address);
            }*/

            //XPath方式
            //获取第一个name元素
            Element nameElement = (Element) rootElement.selectSingleNode("//name");
            System.out.println(nameElement.getText());

            List<Element> list = rootElement.selectNodes("//name");
            for (Element element : list) {
                System.out.println(element.getText());
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
