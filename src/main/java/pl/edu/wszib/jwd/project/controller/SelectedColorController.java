package pl.edu.wszib.jwd.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.wszib.jwd.project.dao.SelectedColorDao;
import pl.edu.wszib.jwd.project.model.SelectedColor;

import java.util.Date;

@Controller
public class SelectedColorController {

    @Autowired
    SelectedColorDao selectedColorDao;

    @Value("${app.title.select}")
    private String title;

    @GetMapping({"/select/{color}","/select"})
    public String selectColorPage(@PathVariable(required = false) String color, Model model) {

        if(!StringUtils.isEmpty(color)) {
            selectedColorDao.save(new SelectedColor(color, new Date()));
            //zapis do bazy
        }

        String[][] colors = {
                {"red", "blue", "purple", "teal"},
                {"black", "orange", "yellow", "green"},
                {"gray", "silver", "olive", "lime"},
                {"navy", "lime", "aqua", "fuschia"},
        };

        model.addAttribute("colors", colors);
        model.addAttribute("title", title);
        return "select";
    }

}
