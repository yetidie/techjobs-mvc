package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    static HashMap search = new HashMap ();

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute ( "columns", ListController.columnChoices );
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results

    @RequestMapping(value = "search")
    public String search(Model model, @RequestParam String typeOfSearch, @RequestParam String term) {

        if (typeOfSearch.equals ( "all" )) {
            ArrayList<HashMap<String, String>> jobs = JobData.findByValue(term);
            model.addAttribute("jobs", jobs);
            model.addAttribute("columns", ListController.columnChoices);
            return "search";
        } else {
            ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(typeOfSearch, term);
            model.addAttribute("jobs", jobs);
            model.addAttribute("columns", ListController.columnChoices);
            return "search";
    }
}}





