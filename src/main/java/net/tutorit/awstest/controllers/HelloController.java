/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.tutorit.awstest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author jyrki
 */
@RestController
@RequestMapping("remote")
public class HelloController {
    @Value("${remote}")
    String remote;
    @Value("${env.database}")
    String database;
    @Value("${some:koe}")
    String some;

    @Autowired
    Environment environment;

    @GetMapping
    public String getIt(RestTemplate rest){
        String ret=rest.getForObject("http://"+remote+"/paintings",String.class);
        return ret;
    }

    @GetMapping(path = "/env",produces = "text/html")
    public String environment() {
        String ret="Directly from application properties<br>";
        ret += "Remote: " + remote + "<br/><br />";
        ret+="From environment variables of the system (through application properties)<br/>";
        ret+="Database: "+database+"<br/><br />";
        ret+="From environment variables of the system (through the injected Environment-object)<br />";
        ret+="Database: "+environment.getProperty("my_database")+"<br/><br />";
        ret+="From virtual machine command line parameters (-Dsome=xxxx)<br /><br />";
        ret+="some: "+some+"<br /><br />";
        return ret;
    }
}
