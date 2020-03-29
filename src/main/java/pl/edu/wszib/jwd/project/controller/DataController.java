package pl.edu.wszib.jwd.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.jwd.project.dao.SelectedColorDao;
import pl.edu.wszib.jwd.project.model.SelectedColor;

@Controller
public class DataController {

    @Value("${app.title.data}")
    private String title;

    @Autowired
    SelectedColorDao selectedColorDao;

    @GetMapping("/data")
    public String dataPage(Model model) {
        Iterable<SelectedColor> selectedColors = selectedColorDao.findAll();
        model.addAttribute("title", title);
        model.addAttribute("selectedColors", selectedColors);
        return "data";
    }
}
