package com.lagou.config;

import com.lagou.pojo.Configuration;
import com.lagou.pojo.MappedStatement;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration =configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException {

        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();

        String namespace = rootElement.attributeValue("namespace");
        List<Element> selectList = rootElement.selectNodes("//select");
        setMapperStatements(selectList,namespace,"SELECT");
        List<Element> updateList = rootElement.selectNodes("//update");
        setMapperStatements(updateList,namespace,"UPDATE");
        List<Element> deleteList = rootElement.selectNodes("//delete");
        setMapperStatements(deleteList,namespace,"DELETE");
        List<Element> insertList = rootElement.selectNodes("//insert");
        setMapperStatements(insertList,namespace,"INSERT");


    }

    private void setMapperStatements(List<Element> elements,String namespace,String methodType){
        for (Element element : elements) {
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");
            String paramterType = element.attributeValue("paramterType");
            String sqlText = element.getTextTrim();
            MappedStatement mappedStatement = new MappedStatement();
            mappedStatement.setId(id);
            mappedStatement.setResultType(resultType);
            mappedStatement.setParamterType(paramterType);
            mappedStatement.setSql(sqlText);
            mappedStatement.setMethodType(methodType);
            String key = namespace+"."+id;
            configuration.getMappedStatementMap().put(key,mappedStatement);
        }
    }


}
