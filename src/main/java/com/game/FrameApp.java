package com.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class FrameApp extends JFrame {

    private Map<String, String> characteristics = new HashMap();

    JButton buttonOk = new JButton("Ok");
    JLabel labelMessage = new JLabel("Pense em um prato que gosta");

    public FrameApp() throws HeadlessException {
        setLayout(new FlowLayout());

        this.add(labelMessage);
        this.add(buttonOk);

        this.setVisible(true);
        this.setTitle("Jogo Gourmet");
        this.setSize(230, 120);
        this.setLocationRelativeTo(null);

        buttonOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        characteristics.put("massa", "lasanha");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void startGame() {
        GameGourmet game = new GameGourmet(characteristics);
        game.tryToGuessFood();
    }
}