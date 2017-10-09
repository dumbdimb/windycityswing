package com.dumbdimb.windycityswing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.dumbdimb.windycityswing.domain.Dance;

import java.io.FileNotFoundException;
import java.util.ArrayList;

@CrossOrigin(origins="*")
@RestController
@EnableAutoConfiguration
public class WindyCitySwingController {
    private final WindyCitySwingService windyCitySwingService;

    @Autowired
    public WindyCitySwingController (WindyCitySwingService service) {
        this.windyCitySwingService = service;
    }
    
    @RequestMapping (
    		value="/dances",
    		method=RequestMethod.GET,
    		produces=MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    ArrayList<Dance> getAllDances() throws FileNotFoundException {
        return windyCitySwingService.getAllDances();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WindyCitySwingController.class, args);
    }
}