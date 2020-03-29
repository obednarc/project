package pl.edu.wszib.jwd.project.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.edu.wszib.jwd.project.model.SelectedColor;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SelectedColorDaoTest {

    public static final String COLOR1 = "red";
    public static final String COLOR2 = "blue";


    @Autowired
    SelectedColorDao selectedColorDao;

    @BeforeEach
    void setUp() {
        SelectedColor selectedColor1 = new SelectedColor(COLOR1, new Date());
        SelectedColor selectedColor2 = new SelectedColor(COLOR2, new Date());

        assertNull(selectedColor1.getId());
        assertNull(selectedColor2.getId());

        selectedColorDao.save(selectedColor1);
        selectedColorDao.save(selectedColor2);

        assertNotNull(selectedColor1.getId());
        assertNotNull(selectedColor2.getId());

    }

    @AfterEach
    void tearDown() {
        selectedColorDao.deleteAll();
    }

    @Test
    void testFetchData() {
        SelectedColor selectedColor = selectedColorDao.findByColor(COLOR1);

        assertNotNull(selectedColor);
        assertEquals(COLOR1, selectedColor.getColor());
    }

    @Test
    void testFetchAllData() {
        Collection selectedColors = (Collection) selectedColorDao.findAll();
        assertEquals(2, selectedColors.size());
    }

}