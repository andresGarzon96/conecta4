package test.conetca4.Model;
import conecta4.Model.Logica;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Andrés
 */
public class LogicaTestCase extends TestCase {
    private Logica logica;

    @Override
    protected void setUp() throws Exception {
        this.logica = new Logica();
    }

    @Override
    protected void tearDown() throws Exception {
        this.logica = null;
    }
    
    @Test
    public void testLogica() {
        
        /*
            Test al constructor de la clase Logica,
            que inicializa las "casillas" del juego y prepara las "fichas" para jugar.
        */
        
        // Verificamos que los componentes se inicialicen completamente.
        assertNotNull(logica.matrizBoton);
        assertNotNull(logica.img1);
        assertNotNull(logica.img2);
        assertNotNull(logica.img3);
    }
    
    @Test
    public void testVolverEmpezar() {
        
        /*
           Test al método VolverEmpezar(),
           que se encarga de reiniciar el juego.
        */
        
        
        // Ejecutamos el método
        logica.VolverEmpezar();
        
        
        // Ahora verificamos el funcionamiento del método.
        
        // Verificamos que todas las casillas del tablero se reinicien.
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                assertNotNull(logica.matrizBoton[i][j]);
            }
        }
        
        // Verificamos que el número de turnos se reinicien.
        assertEquals(0, logica.contadorTurno);
    }
}