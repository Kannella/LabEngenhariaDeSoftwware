import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Tela1 extends JFrame {
    private JTextField[] campos;
    private JButton botaoEntrar;
    private int[] numeros = new int[8];

    public Tela1() {
        setTitle("Tela 1 - Inserção dos Números");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(9, 2));

        campos = new JTextField[8];
        for (int i = 0; i < 8; i++) {
            add(new JLabel("Número " + (i + 1) + ":"));
            campos[i] = new JTextField();
            add(campos[i]);
        }

        botaoEntrar = new JButton("Entra");
        add(botaoEntrar);

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < 8; i++) {
                        numeros[i] = Integer.parseInt(campos[i].getText());
                    }
                    Arrays.sort(numeros);
                    new Tela2(numeros).setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira números válidos.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tela1().setVisible(true));
    }
}