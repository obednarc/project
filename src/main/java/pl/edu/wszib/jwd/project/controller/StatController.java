package pl.edu.wszib.jwd.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.jwd.project.dao.SelectedColorDao;
import pl.edu.wszib.jwd.project.helper.ColorHelper;
import pl.edu.wszib.jwd.project.model.SelectedColor;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class StatController {

    @Autowired
    SelectedColorDao selectedColorDao;

    @Value("${app.title.stat}")
    private String title;

    @GetMapping("/stat")
    public String statisticPage(Model model) {

        Iterable<SelectedColor> selectedColors = selectedColorDao.findAll();
        Collection<SelectedColor> selectedColorCollection
                = (Collection<SelectedColor>) selectedColors;

        Map<String, Long> dataMap = selectedColorCollection.stream()
                .collect(Collectors.groupingBy(SelectedColor::getColor, Collectors.counting()));

        List<String> labels = ColorHelper.convertColors(dataMap.keySet());

        model.addAttribute("title", title);
        model.addAttribute("dataMap", dataMap);
        model.addAttribute("labels", labels);
        return "stat";
    }
}