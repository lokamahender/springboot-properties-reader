package com.springboot.properties.reader.controller;

import com.springboot.properties.reader.pojo.CommonProperties;
import com.springboot.properties.reader.pojo.Properties;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author mahenderloka
 */

@RestController
@RequestMapping("/project/properties")
public class PropertyReader {

    @Autowired
    private Properties properties;

    @Autowired
    private CommonProperties commonProperties;

    //few more ways to do

    @Value("${TIMEZONE}")
    private String timezone;

    @Value("${SUPPORTED.TIMEZONE}")
    private List<String> supportedTimezones;

    @Value("#{${CONNECTION.STRING.DETAILS}}")
    private Map<String, String> connectionStringDetails;

    @GetMapping("/getProperties")
    public String getProperties(){

        JSONObject obj = new JSONObject();

        obj.put("databaseUrl", properties.getDatabaseUrl());
        obj.put("userName", properties.getUserName());
        obj.put("password", properties.getPassword());
        obj.put("secretKey", properties.getSecretKey());
        obj.put("environment", properties.getEnvironment());

        //Adding new keys
        obj.put("timezone", timezone);
        obj.put("supportedTimezones", supportedTimezones);
        obj.put("connectionStringDetails",connectionStringDetails);

        System.out.println(" ************ properties ****************\n"+ obj);
        System.out.println(" ************ properties ****************\n");

        return obj.toString();
    }

    @GetMapping("/getAllProperties")
    public String getAllProperties(){

        //this api gives properties from both common and server config files

        JSONObject obj = new JSONObject();

        obj.put("databaseUrl", commonProperties.getDatabaseUrl());
        obj.put("userName", commonProperties.getUserName());
        obj.put("password", commonProperties.getPassword());
        obj.put("secretKey", commonProperties.getSecretKey());
        obj.put("environment", commonProperties.getEnvironment());

        obj.put("serverName", commonProperties.getServerName());
        obj.put("ipAddress", commonProperties.getIpAddress());
        obj.put("active", commonProperties.getActive());

        System.out.println(" ************ common properties ****************\n"+ obj);
        System.out.println(" ************ common properties ****************\n");

        return obj.toString();
    }
}
