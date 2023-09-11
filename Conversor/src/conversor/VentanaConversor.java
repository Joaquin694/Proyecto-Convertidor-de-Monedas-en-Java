package conversor;

import javax.swing.*;
import java.awt.*;

public class VentanaConversor extends JFrame {
    public VentanaConversor() {
        setTitle("Conversor de Moneda a Pesos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        ConversorMonedaPanel panel = new ConversorMonedaPanel();
        add(panel);
    }

    public void mostrar() {
        setVisible(true);
    }
}
