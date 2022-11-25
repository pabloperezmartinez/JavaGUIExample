import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Creates frame
        JFrame frame = new JFrame("Chat Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Creates MenuBar y menubar componentes
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Archivo");
        JMenu helpMenu = new JMenu("Ayuda");
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        JMenuItem openItem = new JMenuItem("Abrir");
        JMenuItem saveItem = new JMenuItem("Guardar como");
        fileMenu.add(openItem);
        helpMenu.add(saveItem);

        // Creates Panel on inferior part and adds components
        JPanel panel = new JPanel(); // panel is not visible yet
        JLabel messageLabel = new JLabel("Mensaje: ");
        JTextField chatTextField = new JTextField(10); // acepta hasta 10 caracteres
        JButton sendButton = new JButton("Enviar");
        JButton resetButton = new JButton("Restablecer");

        
        panel.setLayout(new FlowLayout());
        panel.add(messageLabel); // Componentes agregados usando Flow Layout
        panel.add(chatTextField);
        panel.add(sendButton);
        panel.add(resetButton);
        
        // Create text Area
        JTextArea chatHistory = new JTextArea();
        chatHistory.setEditable(false);
        
        // Add components into frame
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, chatHistory);

        sendButton.addActionListener(e -> addMessage(chatTextField.getText(), chatHistory, chatTextField));
        resetButton.addActionListener(e -> resetTextField(chatTextField));

        frame.setVisible(true);
    }
    
    public static void resetTextField(JTextField target) {
        target.setText("");
    }

    public static void addMessage(String message, JTextArea targetTextArea, JTextField targetTextField) {
        targetTextArea.append("\nPablo dice: " + message);
        resetTextField(targetTextField);
    }
}
