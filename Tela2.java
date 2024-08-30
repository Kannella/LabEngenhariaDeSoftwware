import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Tela2 extends JFrame {
    private JTextField campoChave; // campo de texto para a chave de busca
    private JButton botaoEntrar; // botão de entrada
    private int[] numeros; // números ordenados

    public Tela2(int[] numeros) { // construtor da tela 2
        this.numeros = numeros; // atribui os números ordenados

        setTitle("Tela 2 - Busca da Chave"); // título da tela
        setSize(300, 150); // tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // operação padrão de fechamento
        setLayout(new GridLayout(2, 2)); // layout da tela

        add(new JLabel("Digite a chave de busca:")); // rótulo
        campoChave = new JTextField(); // campo de texto para a chave de busca
        add(campoChave); // adiciona o campo de texto ao painel

        botaoEntrar = new JButton("Entra"); // botão de entrada
        add(botaoEntrar); // adiciona o botão de entrada ao painel

        botaoEntrar.addActionListener(new ActionListener() { // ação do botão de entrada
            @Override // sobrescreve o método actionPerformed da interface ActionListener
            public void actionPerformed(ActionEvent e) {   // ação do botão de entrada
                try { // tenta executar o bloco de código
                    int chave = Integer.parseInt(campoChave.getText()); // converte o texto do campo para inteiro
                    boolean encontrado = false; // chave não encontrada
                    int posicao = -1;   // posição da chave
                    for (int i = 0; i < numeros.length; i++) { // para cada número no array de números
                        if (numeros[i] == chave) { // se o número for igual à chave
                            encontrado = true; // chave encontrada
                            posicao = i; // posição da chave
                            break; // interrompe o laço
                        }
                    }
                    new Tela3(encontrado, posicao).setVisible(true); // exibe a tela 3 com o resultado da busca
                    dispose();  // fecha a tela 2
                } catch (NumberFormatException ex) { // se houver erro na conversão do texto para inteiro
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido."); // exibe mensagem de erro ao usuário
                }
            }
        });
    }
}