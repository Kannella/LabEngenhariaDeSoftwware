import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela1 {

    // Array para armazenar os números
    private static int[] storedNumbers = {10, 20, 30, 40, 50, 60, 70, 80};

    public static void main(String[] args) {
        // Criação da janela principal
        JFrame frame = new JFrame("Busca de Números");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        
        // Layout da janela
        frame.setLayout(new GridLayout(3, 2));
        
        // Rótulo e campo de texto para entrada do número
        JLabel label = new JLabel("Digite um número para buscar:");
        JTextField textField = new JTextField();
        
        // Botão para iniciar a busca
        JButton searchButton = new JButton("Entra");
        
        // Área de texto para mostrar o resultado
        JTextArea resultArea = new JTextArea();
        resultArea.setEditable(false);

        // Adiciona componentes à janela
        frame.add(label);
        frame.add(textField);
        frame.add(searchButton);
        frame.add(new JLabel("Resultado:"));
        frame.add(resultArea);
        
        // Configuração do botão de busca
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                try {
                    int numberToSearch = Integer.parseInt(input);
                    int position = searchNumber(numberToSearch);
                    if (position != -1) {
                        resultArea.setText("Número encontrado na posição: " + position);
                    } else {
                        resultArea.setText("Número não encontrado nos números armazenados.");
                    }
                } catch (NumberFormatException ex) {
                    resultArea.setText("Por favor, digite um número inteiro válido.");
                }
            }
        });

        // Exibe a janela
        frame.setVisible(true);
    }

    // Método para buscar o número no array
    private static int searchNumber(int number) {
        for (int i = 0; i < storedNumbers.length; i++) {
            if (storedNumbers[i] == number) {
                return i; // Retorna a posição do número encontrado
            }
        }
        return -1; // Retorna -1 se o número não for encontrado
    }
}
