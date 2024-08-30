import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Tela3 extends JFrame { // tela 3
    public Tela3(boolean encontrado, int posicao) { // Construtor da tela 3 que recebe se a chave foi encontrada e a posição
        setTitle("Tela 3 - Resultado da Busca");  // Título da tela
        setSize(300, 150); // Tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Operação padrão de fechamento
        setLayout(new GridLayout(2, 1)); // Layout da tela

        String mensagem; // Mensagem a ser exibida
        if (encontrado) { // Se a chave foi encontrada
            mensagem = "Chave encontrada na posição: " + (posicao + 1); // Mensagem de sucesso
        } else { // Se a chave não foi encontrada
            mensagem = "Chave não encontrada."; // Mensagem de erro
        }

        add(new JLabel(mensagem)); // Adiciona a mensagem ao painel

        JButton botaoEntrar = new JButton("Entra"); // Botão de entrada
        add(botaoEntrar); // Adiciona o botão de entrada ao painel

        botaoEntrar.addActionListener(new ActionListener() { // Ação do botão de entrada
            @Override // Sobrescreve o método actionPerformed da interface ActionListener
            public void actionPerformed(ActionEvent e) { // Ação do botão de entrada
                dispose(); // Fecha a tela 3
                System.exit(0); // Encerra a aplicação
            }
        });
    }
}