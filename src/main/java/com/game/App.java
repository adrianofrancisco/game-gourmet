package com.game;

import javax.swing.*;

public class App {

    public static void main(String[] args) {

        FrameApp frame = new FrameApp();

        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.okButtonText", "OK");
    }
}
