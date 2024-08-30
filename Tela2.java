import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Tela2 extends JFrame {
    private JTextField campoChave;
    private JButton botaoEntrar;
    private int[] numeros;

    public Tela2(int[] numeros) {
        this.numeros = numeros;

        setTitle("Tela 2 - Busca da Chave");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        add(new JLabel("Digite a chave de busca:"));
        campoChave = new JTextField();
        add(campoChave);

        botaoEntrar = new JButton("Entra");
        add(botaoEntrar);

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int chave = Integer.parseInt(campoChave.getText());
                    boolean encontrado = false;
                    int posicao = -1;
                    for (int i = 0; i < numeros.length; i++) {
                        if (numeros[i] == chave) {
                            encontrado = true;
                            posicao = i;
                            break;
                        }
                    }
                    new Tela3(encontrado, posicao).setVisible(true);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                }
            }
        });
    }
}