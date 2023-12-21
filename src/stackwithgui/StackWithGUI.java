/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stackwithgui;

/**
 *
 * @author khair
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class StackWithGUI extends JFrame {
    private Stack<String> stack;
    private JTextArea stackTextArea;
    private JTextField inputTextField;

    public StackWithGUI() {
        stack = new Stack<>();
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Stack with GUI");

        // Input field
        inputTextField = new JTextField(20);
        JButton pushButton = new JButton("Push");
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                push();
            }
        });

        // Stack display area
        stackTextArea = new JTextArea(10, 20);
        stackTextArea.setEditable(false);

        // Pop button
        JButton popButton = new JButton("Pop");
        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pop();
            }
        });

        // Panel for components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(inputTextField);
        panel.add(pushButton);
        panel.add(popButton);

        // Add components to the frame
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(stackTextArea), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    private void push() {
        String item = inputTextField.getText();
        if (!item.isEmpty()) {
            stack.push(item);
            updateStackDisplay();
            inputTextField.setText("");
        }
    }

    private void pop() {
        if (!stack.isEmpty()) {
            String poppedItem = stack.pop();
            JOptionPane.showMessageDialog(this, "Popped: " + poppedItem);
            updateStackDisplay();
        } else {
            JOptionPane.showMessageDialog(this, "Stack is empty!");
        }
    }

    private void updateStackDisplay() {
        stackTextArea.setText("");
        for (int i = stack.size() - 1; i >= 0; i--) {
            String item = stack.get(i);
            if (i == stack.size() - 1) {
                // Highlight the top element
                stackTextArea.append(  item + " << TOP \n");
            } else {
                stackTextArea.append(item + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StackWithGUI().setVisible(true);
            }
        });
    }
}
