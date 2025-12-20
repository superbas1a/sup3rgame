import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class Main extends JFrame {

    public Main(){
        super("title");
        setSize(550, 600);
        Button button1 = new Button("1");
        Button button2 = new Button("2");
        Button button3 = new Button("3");
        Button button4 = new Button("4");
        Button button5 = new Button("5");
        Button button6 = new Button("6");
        Button button7 = new Button("7");
        Button button8 = new Button("8");
        Button button9 = new Button("9");
        Button button0 = new Button("0");
        Button button_clean = new Button("C");
        Button button_plus = new Button("+");
        Button button_minus = new Button("-");
        Button button_umnojit = new Button("*");
        Button button_ravno = new Button("=");
        Button button_delit = new Button("/");
        setLayout(null);
        JTextField textField;
        textField = new JTextField(20);
        textField.setText("");
        textField.setBounds(50,0, 450, 100);
        button1.setBounds(100, 100, 50, 50);
        button2.setBounds(200, 100, 50, 50);
        button3.setBounds(300, 100, 50, 50);
        button4.setBounds(100, 200, 50, 50);
        button5.setBounds(200, 200, 50, 50);
        button6.setBounds(300, 200, 50, 50);
        button7.setBounds(100, 300, 50, 50);
        button8.setBounds(200, 300, 50, 50);
        button9.setBounds(300, 300, 50, 50);
        button0.setBounds(200, 400, 50, 50);
        button_clean.setBounds(100, 400, 50, 50);
        button_plus.setBounds(400, 100, 50, 50);
        button_minus.setBounds(400, 300, 50, 50);
        button_umnojit.setBounds(400, 400, 50, 50);
        button_ravno.setBounds(300, 400, 50, 50);
        button_delit.setBounds(400, 200, 50, 50);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
        add(button0);
        add(button_clean);
        add(button_plus);
        add(button_minus);
        add(button_umnojit);
        add(button_ravno);
        add(button_delit);
        add(textField);
        final int[] plusflag = {0};
        final int[] minusflag = {0};
        final int[] umnojitflag = {0};
        final int[] delitflag = {0};
        final int[][] first = {{0}};
        final int[][] second = {{0}};
        final int[][] flag = {{0}};
        final int[][] itog = {{0}};



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField.setText(textField.getText() + "1");
                if (flag[0][0] == 0) {
                    first[0][0] = first[0][0] * 10 + 1;
                }
                if (flag[0][0] == 1) {
                    second[0][0] = second[0][0] * 10 + 1;
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField.setText(textField.getText() + "2");
                if (flag[0][0] == 0) {
                    first[0][0] = first[0][0] * 10 + 2;
                }
                if (flag[0][0] == 1) {
                    second[0][0] = second[0][0] * 10 + 2;
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField.setText(textField.getText() + "3");
                if (flag[0][0] == 0) {
                    first[0][0] = first[0][0] * 10 + 3;
                }
                if (flag[0][0] == 1) {
                    second[0][0] = second[0][0] * 10 + 3;
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField.setText(textField.getText() + "4");
                if (flag[0][0] == 0) {
                    first[0][0] = first[0][0] * 10 + 4;
                }
                if (flag[0][0] == 1) {
                    second[0][0] = second[0][0] * 10 + 4;
                }
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField.setText(textField.getText() + "5");
                if (flag[0][0] == 0) {
                    first[0][0] = first[0][0] * 10 + 5;
                }
                if (flag[0][0] == 1) {
                    second[0][0] = second[0][0] * 10 + 5;
                }
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField.setText(textField.getText() + "6");
                if (flag[0][0] == 0) {
                    first[0][0] = first[0][0] * 10 + 6;
                }
                if (flag[0][0] == 1) {
                    second[0][0] = second[0][0] * 10 + 6;
                }
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField.setText(textField.getText() + "7");
                if (flag[0][0] == 0) {
                    first[0][0] = first[0][0] * 10 + 7;
                }
                if (flag[0][0] == 1) {
                    second[0][0] = second[0][0] * 10 + 7;
                }
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField.setText(textField.getText() + "8");
                if (flag[0][0] == 0) {
                    first[0][0] = first[0][0] * 10 + 8;
                }
                if (flag[0][0] == 1) {
                    second[0][0] = second[0][0] * 10 + 8;
                }
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField.setText(textField.getText() + "9");
                if (flag[0][0] == 0) {
                    first[0][0] = first[0][0] * 10 + 9;
                }
                if (flag[0][0] == 1) {
                    second[0][0] = second[0][0] * 10 + 9;
                }
            }
        });
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField.setText(textField.getText() + "0");
                if (flag[0][0] == 0) {
                    first[0][0] = first[0][0] * 10;
                }
                if (flag[0][0] == 1) {
                    second[0][0] = second[0][0] * 10;
                }
            }
        });
        button_clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField.setText("");
                first[0] = new int[]{0};
                second[0] = new int[]{0};
                flag[0] = new int[]{0};

            }
        });
        button_plus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {textField.setText("+");
                plusflag[0]++;
                flag[0][0]++;
            }
        });
        button_minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {textField.setText("-");
                minusflag[0]++;
                flag[0][0]++;
            }
        });
        button_umnojit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("*");
                umnojitflag[0]++;
                flag[0][0]++;
            }
        });
        button_delit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("/");
                delitflag[0]++;
                flag[0][0]++;
            }
        });
        button_ravno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (plusflag[0] == 1) {
                    itog[0] = new int[]{first[0][0] + second[0][0]};
                }
                if (minusflag[0] == 1) {
                    itog[0] = new int[]{first[0][0] - second[0][0]};
                }
                if (umnojitflag[0] == 1) {
                    itog[0] = new int[]{first[0][0] * second[0][0]};
                }
                if (delitflag[0] == 1) {
                    itog[0] = new int[]{first[0][0] / second[0][0]};

                }
                    textField.setText(Arrays.toString(itog[0]));

            }
        });


    }

    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
    }
}