import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ValidadorTest {
    @Test
    void deveValidarCPFValido() {
      assertTrue(Validador.validarCPF("529.982.247-25"));
    }

    @Test
    void testeCPFSemFiltro(){
        assertTrue(Validador.validarCPF("52998224725"));
    }

    @Test
    void rejeitaCPFNull(){
        assertFalse(Validador.validarCPF(null));
    }

    @Test
    void rejeitarCPFSemNada(){
        assertFalse(Validador.validarCPF(""));
    }

    @Test
    void rejeitarCPFZoado(){
        assertFalse(Validador.validarCPF("529.982.247-2X"));
    }

    @Test
    void rejeitarCPFZerado() {
        assertFalse(Validador.validarCPF("00000000000"));   // sequência repetida
    }
}
