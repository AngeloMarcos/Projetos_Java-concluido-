import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class Interface {
    // declaracao das variaveis

    double n1 = 0.0;
    double n2 = 0.0;
    String operador = "";

    private JFrame frame;
    private JTextField tela;

    private double calcularResultado() {
        n2 = Double.parseDouble(tela.getText());

        double resultado = 0.0;
        switch (operador) {
            case "+":
                resultado = n1 + n2;
                break;
            case "-":
                resultado = n1 - n2;
                break;
            case "X":
                resultado = n1 * n2;
                break;
            case "/":
                resultado = n1 / n2;
                break;
            case "%":
                resultado = n1 % n2;
                break;
        }
        return resultado;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interface window = new Interface();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Interface() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(0, 185, 185));
        frame.setBounds(100, 100, 341, 519);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        tela = new JTextField();
        tela.setBounds(0, 0, 324, 59);
        frame.getContentPane().add(tela);
        tela.setColumns(10);

        JButton b_1 = new JButton("1");
        b_1.setBounds(10, 170, 65, 59);
        frame.getContentPane().add(b_1);

        b_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tela.getText();
                tela.setText(text + "1");
            }
        });

        JButton b_2 = new JButton("2");
        b_2.setBounds(87, 170, 65, 59);
        frame.getContentPane().add(b_2);

        b_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tela.getText();
                tela.setText(text + "2");
            }
        });

        JButton b_3 = new JButton("3");
        b_3.setBounds(162, 170, 65, 59);
        frame.getContentPane().add(b_3);

        b_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tela.getText();
                tela.setText(text + "3");
            }
        });

        JButton b_mais = new JButton("+");
        b_mais.setBounds(245, 240, 65, 59);
        frame.getContentPane().add(b_mais);

        b_mais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                n1 = Double.parseDouble(tela.getText());
                operador = "+";
                tela.setText("");
            }
        });

        JButton b_menos = new JButton("-");
        b_menos.setBounds(245, 170, 65, 59);
        frame.getContentPane().add(b_menos);

        b_menos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                n1 = Double.parseDouble(tela.getText());
                operador = "-";
                tela.setText("");
            }
        });

        JButton b_4 = new JButton("4");
        b_4.setBounds(10, 241, 65, 59);
        frame.getContentPane().add(b_4);
        b_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tela.getText();
                tela.setText(text + "4");
            }
        });

        JButton b_5 = new JButton("5");
        b_5.setBounds(87, 241, 65, 59);
        frame.getContentPane().add(b_5);
        b_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tela.getText();
                tela.setText(text + "5");
            }
        });

        JButton b_6 = new JButton("6");
        b_6.setBounds(162, 241, 65, 59);
        frame.getContentPane().add(b_6);
        b_6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tela.getText();
                tela.setText(text + "6");
            }
        });

        JButton b_mult = new JButton("x");
        b_mult.setBounds(245, 85, 65, 59);
        frame.getContentPane().add(b_mult);
        b_mult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                n1 = Double.parseDouble(tela.getText());
                operador = "X";
                tela.setText("");
            }
        });

        JButton b_7 = new JButton("7");
        b_7.setBounds(10, 324, 65, 59);
        frame.getContentPane().add(b_7);
        b_7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tela.getText();
                tela.setText(text + "7");
            }
        });

        JButton b_8 = new JButton("8");
        b_8.setBounds(87, 324, 65, 59);
        frame.getContentPane().add(b_8);
        b_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tela.getText();
                tela.setText(text + "8");
            }
        });

        JButton b_9 = new JButton("9");
        b_9.setBounds(162, 324, 65, 59);
        frame.getContentPane().add(b_9);
        b_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tela.getText();
                tela.setText(text + "9");
            }
        });

        JButton b_ponto = new JButton(".");
        b_ponto.setBounds(162, 405, 65, 59);
        frame.getContentPane().add(b_ponto);
        b_ponto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tela.getText();
                if (!text.contains(".")) {
                    tela.setText(text + ".");
                }
            }
        });

        JButton b_0 = new JButton("0");
        b_0.setBounds(10, 405, 142, 59);
        frame.getContentPane().add(b_0);
        b_0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = tela.getText();
                tela.setText(text + "0");
            }
        });

        JButton porcentagem = new JButton("%");
        porcentagem.setBounds(87, 85, 65, 59);
        frame.getContentPane().add(porcentagem);
        porcentagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                n1 = Double.parseDouble(tela.getText());
                operador = "%";
                tela.setText("");
            }
        });

        JButton b_div = new JButton("/");
        b_div.setBounds(245, 324, 65, 59);
        frame.getContentPane().add(b_div);
        b_div.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                n1 = Double.parseDouble(tela.getText());
                operador = "/";
                tela.setText("");
            }
        });

        JButton b_igual = new JButton("=");
        b_igual.setBounds(245, 405, 65, 59);
        frame.getContentPane().add(b_igual);
        b_igual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double resultado = calcularResultado();
                tela.setText(String.format("%.0f", resultado));

            }
        });

        JButton b_limpar = new JButton("C");
        b_limpar.setBounds(10, 85, 65, 59);
        frame.getContentPane().add(b_limpar);
        b_limpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                n1 = 0.0;
                n2 = 0.0;
                operador = "";
                tela.setText("");
            }
        });

        JLabel lblCalculadora = new JLabel("Calculadora");
        lblCalculadora.setBounds(119, 58, 86, 16);
        frame.getContentPane().add(lblCalculadora);

        frame.setLocationRelativeTo(null);
    }
}
