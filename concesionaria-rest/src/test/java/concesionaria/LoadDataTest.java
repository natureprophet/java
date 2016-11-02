package concesionaria;

import concesionaria.dto.ConcesionariaDTO;
import concesionaria.services.ConcesionariaServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoadDataTest {

    @Autowired
    ConcesionariaServices concesionariaServices;

    @Test
    public void loadData() {
        ConcesionariaDTO dto = new ConcesionariaDTO();
        dto.setNombre("yacopini");
        dto.setDireccion("san martin 123456");
        dto.setTelefono("123456789");
        dto.getMarcas().add("ford");
        dto.getMarcas().add("bmw");
        dto.getMarcas().add("chevrolet");
        concesionariaServices.createConcesionaria(dto);
    }
}
