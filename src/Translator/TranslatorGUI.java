package Translator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

public class TranslatorGUI extends JFrame {
    private JTextArea inputTA = new JTextArea();
    private JTextArea outputTA = new JTextArea();
    private JButton translateBtn = new JButton("Translate");
    private JComboBox langCombo = new JComboBox(lang);
    private JPanel textPnl = new JPanel();
    private JPanel inputPnl = new JPanel();
    private JPanel outputPnl = new JPanel();
    private JPanel southPnl = new JPanel();
    private TranslateStrategy translator;
    private static final String[] lang = {"French", "German", "Spanish"};

    public TranslatorGUI() {
        initComponents();
    }

    private void initComponents() {
        inputTA.setPreferredSize(new Dimension(350, 200));
        outputTA.setPreferredSize(new Dimension(350, 200));

        inputPnl.setBorder(new EmptyBorder(new Insets(20, 5, 5, 5)));
        outputPnl.setBorder(new EmptyBorder(new Insets(20, 5, 5, 5)));
        inputPnl.add(inputTA);
        outputPnl.add(outputTA);
        textPnl.setLayout(new GridLayout(1, 2));
        textPnl.add(inputPnl);
        textPnl.add(outputPnl);

        southPnl.setLayout(new FlowLayout());
        southPnl.add(translateBtn);
        southPnl.add(langCombo);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(textPnl);
        add(southPnl);

        pack();
        setPreferredSize(new Dimension(800, 450));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        translateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                translateBtnActionPerformed();
            }
        });
    }

    private void translateBtnActionPerformed() {
        String language = (String) langCombo.getSelectedItem();

        if (language.equals("French")) {
            translator = new FrenchTranslator();
        } else if (language.equals("German")) {
            translator = new GermanTranslator();
        } else if (language.equals("Spanish")) {
            translator = new SpanishTranslator();
        }

        outputTA.setText(translator.translate(inputTA.getText()));
    }

    public static void main(String[] args) {
        TranslatorGUI app = new TranslatorGUI();
    }
}
