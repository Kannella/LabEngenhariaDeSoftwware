import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Tela3 extends JFrame {
    public Tela3(boolean encontrado, int posicao) {
        setTitle("Tela 3 - Resultado da Busca");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        String mensagem;
        if (encontrado) {
            mensagem = "Chave encontrada na posição: " + (posicao + 1);
        } else {
            mensagem = "Chave não encontrada.";
        }

        add(new JLabel(mensagem));

        JButton botaoEntrar = new JButton("Entra");
        add(botaoEntrar);

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }
}