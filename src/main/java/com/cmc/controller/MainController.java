/**
 * 
 */
package com.cmc.controller;

import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author User
 * @creatdate Oct 26, 2018
 * @modifieddate Oct 26, 2018
 * @content ...
 */
public class MainController {

        @GetMapping("/")
        public String index() {
                return "index";
        }
}
