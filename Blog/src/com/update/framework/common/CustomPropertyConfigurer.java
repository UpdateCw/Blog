package com.update.framework.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 
 * @author cw
 * @date 2016年10月21日
 * @vsersion 1.0
 * DOTO (解析spring property配置文件)
 */
public class CustomPropertyConfigurer extends PropertyPlaceholderConfigurer {

    private static Map<String, Object> ctxPropertiesMap;
    
    static {
        System.setProperty(LogFactory.FACTORY_PROPERTY, LogFactory.FACTORY_DEFAULT);
    }

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        ctxPropertiesMap = new HashMap<String, Object>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            ctxPropertiesMap.put(keyStr, value);
            System.setProperty(keyStr, value);
        }
    }

    public static Object getContextProperty(String name) {
        return ctxPropertiesMap.get(name);
    }
}
