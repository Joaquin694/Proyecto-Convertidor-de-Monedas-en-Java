package conversor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ConversorMonedaPanel extends JPanel {
    private JComboBox<String> monedaOrigen;
    private JComboBox<String> monedaDestino;
    private JTextField cantidadInput;
    private JLabel resultadoLabel;

    private static final double[] tasas = {1.0, 0.85, 0.73, 109.37, 1171.41};

    public ConversorMonedaPanel() {
        setLayout(new BorderLayout());

        monedaOrigen = new JComboBox<>(new String[]{"Pesos (Tu país)", "Dólar", "Euro", "Libra", "Yen", "Won"});
        monedaDestino = new JComboBox<>(new String[]{"Pesos (Tu país)", "Dólar", "Euro", "Libra", "Yen", "Won"});
        cantidadInput = new JTextField(10);
        resultadoLabel = new JLabel("Resultado:");

        JButton convertirButton = new JButton("Convertir");
        convertirButton.addActionListener(e -> convertirMoneda());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Moneda de origen:"));
        panel.add(monedaOrigen);
        panel.add(new JLabel("Moneda de destino:"));
        panel.add(monedaDestino);
        panel.add(new JLabel("Cantidad:"));
        panel.add(cantidadInput);

        JPanel resultadoPanel = new JPanel();
        resultadoPanel.setLayout(new FlowLayout());
        resultadoPanel.add(resultadoLabel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(convertirButton);

        add(panel, BorderLayout.NORTH);
        add(resultadoPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void convertirMoneda() {
        try {
            double cantidad = Double.parseDouble(cantidadInput.getText());
            int monedaOrigenIndex = monedaOrigen.getSelectedIndex();
            int monedaDestinoIndex = monedaDestino.getSelectedIndex();
            double tasaOrigen = tasas[monedaOrigenIndex];
            double tasaDestino = tasas[monedaDestinoIndex];

            double resultado = (cantidad / tasaOrigen) * tasaDestino;

            DecimalFormat df = new DecimalFormat("#.##");
            resultadoLabel.setText("Resultado: " + df.format(resultado));
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Error: Ingresa una cantidad válida.");
        }
    }
}
