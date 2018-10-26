/**
 * 
 */
package com.cmc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author User
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
@Controller
public class MainController {

        @GetMapping("/")
        public String index(ModelMap modelMap) {
               
                return "index";
        }
}
