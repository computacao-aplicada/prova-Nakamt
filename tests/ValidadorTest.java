import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ValidadorTest {
    @Test
    public void testeCPFcomFiltro() {
      assertTrue(Validador.validarCPF("137.667.729-61"));
    }

    @Test
    public void testeCPFSemFiltro(){
        assertTrue(Validador.validarCPF("13766772961"));
    }

    @Test
    public void rejeitaCPFNull(){
        assertFalse(Validador.validarCPF(null));
    }

    @Test
    public void rejeitarCPFSemNada(){
        assertFalse(Validador.validarCPF(""));
    }

    @Test
    public void rejeitarCPFZoado(){
        assertFalse(Validador.validarCPF("137.667.729-XY"));
    }

    @Test
    public void rejeitarCPFZerado() {
        assertFalse(Validador.validarCPF("00000000000"));
    }

    @Test
    public void rejeitarDVErradissimo() {
        assertFalse(Validador.validarCPF("137.667.729-60"));
    }

    @Test
    public void rejeitarDVErradissimo2(){
        assertFalse(Validador.validarCPF("123.456.789-10"));
    }


}
