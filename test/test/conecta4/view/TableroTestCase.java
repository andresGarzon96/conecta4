package test.conecta4.view;
import conecta4.View.Tablero;
import junit.framework.TestCase;
import org.junit.Test;

/**
 *
 * @author Andrés
 */
public class TableroTestCase extends TestCase {
    private Tablero tablero;

    @Override
    protected void setUp() throws Exception {
        this.tablero = new Tablero();
    }

    @Override
    protected void tearDown() throws Exception {
        this.tablero = null;
    }
    
    @Test
    public void testTablero () {
        
        /*
        * Test al método constructor de la clase Tablero
        * Tablero es la Ventana que muestra las casillas y las fichas al jugar CONECTA 4.
        */
        
        assertNotNull(tablero);                             // Comprobar que el tablero de juego se haya creado.
        assertNotNull(tablero.getJMenuBar());               // Comprobar que la barra de menú se haya creado.
        assertNotNull(tablero.getLayeredPane());            // Comprobar que el panel principal se haya creado.
        assertEquals("CONECTA 4", tablero.getTitle());      // Comprobar que el título sea el correcto.
        assertTrue(tablero.isVisible());                    // Comprobar que la ventana se muestre.
        assertFalse(tablero.isResizable());                 // Comprobar que la ventana no se pueda cambiar de tamaño.
    }
}
