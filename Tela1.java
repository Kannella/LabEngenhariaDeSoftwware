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

        campos = new JTextField[8]; // 8 campos de texto
        for (int i = 0; i < 8; i++) { // 8 rótulos e 8 campos de texto
            add(new JLabel("Número " + (i + 1) + ":")); // rótulo
            campos[i] = new JTextField(); // campo de texto para o número i
            add(campos[i]); // adiciona o campo de texto ao painel
        }

        botaoEntrar = new JButton("Entra"); // botão de entrada
        add(botaoEntrar); // adiciona o botão de entrada ao painel

        botaoEntrar.addActionListener(new ActionListener() { // ação do botão de entrada
            @Override // sobrescreve o método actionPerformed da interface ActionListener
            public void actionPerformed(ActionEvent e) { // ação do botão de entrada
                try {
                    for (int i = 0; i < 8; i++) { // para cada campo de texto
                        numeros[i] = Integer.parseInt(campos[i].getText());
                    } // converte o texto do campo para inteiro
                    Arrays.sort(numeros); // ordena os números
                    new Tela2(numeros).setVisible(true); // exibe a tela 2 com os números ordenados
                    dispose(); // fecha a tela 1
                } catch (NumberFormatException ex) { // se houver erro na conversão
                    JOptionPane.showMessageDialog(null, "Por favor, insira números inteiros."); // exibe mensagem de erro
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Tela1().setVisible(true));
    }
}