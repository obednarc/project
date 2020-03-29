package pl.edu.wszib.jwd.project.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.jwd.project.model.SelectedColor;

@Repository
public interface SelectedColorDao extends CrudRepository<SelectedColor, Integer> {
    SelectedColor findByColor(String color);
}
