package conversor;

import javax.swing.SwingUtilities;

public class ConversorMoneda {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaConversor ventana = new VentanaConversor();
            ventana.mostrar();
        });
    }
}

