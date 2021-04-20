package com.test.fkredis.common.util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.IOException;
import java.io.StringWriter;

public class XmlUtils {

    private static final Logger logger = LoggerFactory.getLogger(XmlUtils.class);

    public static <T> String ObjectToXmlWhitProlog(T javaBean) {
        StringWriter stringWriter = new StringWriter();
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
        try {
            XMLStreamWriter sw = xmlOutputFactory.createXMLStreamWriter(stringWriter);
            XmlMapper mapper = new XmlMapper();

            sw.writeStartDocument();

//        sw.writeStartElement("tag");
            mapper.writeValue(sw, javaBean);
//        sw.writeComment("Some comment");
//        sw.writeEndElement("/tag");
            sw.writeEndDocument();
        } catch (XMLStreamException | IOException e) {
            logger.error("XML转换错误:", e);
        }
        return stringWriter.toString();
    }

    public static String convertToXml(Object obj) {
        // 创建输出流
        StringWriter sw = new StringWriter();
        try {
            // 利用jdk中自带的转换类实现
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 格式化xml输出的格式
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            // 将对象转换成输出流形式的xml
            marshaller.marshal(obj, sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return sw.toString();
    }
}
