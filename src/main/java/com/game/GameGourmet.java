package com.game;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class GameGourmet {
    public static final Integer SIM = 0;
    public static final Integer NAO = 1;
    public static final String FOOD_DEFAULT = "Bolo de Chocolate";

    private Map<String, String> characteristics;

    public GameGourmet(Map<String, String> characteristics) {
        this.characteristics = characteristics;
    }

    public void addValuesListGoumert(String key, String value) {
        characteristics.put(key, value);
    }

    public Integer questionThinkingFood(String nameFood) {
        Object[] options = {"Sim", "Não"};

        return JOptionPane.showOptionDialog(
                null,
                "O prato que você pensou é " + nameFood + "?",
                "Confirm",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
    }

    public void registerNewFood() {
        String nameFood = JOptionPane.showInputDialog(
                null,
                "Qual prato você pensou?",
                "Desisto",
                JOptionPane.QUESTION_MESSAGE
        );

        String keyFood = JOptionPane.showInputDialog(
                null,
                nameFood + " é _________ mas " + FOOD_DEFAULT + " não.",
                "Complete",
                JOptionPane.QUESTION_MESSAGE
        );

        addValuesListGoumert(keyFood, nameFood);
    }

    public void messageSuccess() {
        JOptionPane.showConfirmDialog(
                null,
                "Acertei de novo!",
                "Jogo Gourmet",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void tryToGuessFood() {
        Integer option = 0;
        Integer count = 0;

        for (String nameFood : characteristics.keySet()) {
            count++;
            option = questionThinkingFood(nameFood);

            if (SIM.equals(option)) {
                option = questionThinkingFood(characteristics.get(nameFood));
                if (SIM.equals(option)) {
                    messageSuccess();
                    break;
                } else {
                    registerNewFood();
                    break;
                }
            }

            if (count == characteristics.keySet().size()) {
                option = questionThinkingFood(FOOD_DEFAULT);
                if (SIM.equals(option)) {
                    messageSuccess();
                    break;
                }

                registerNewFood();
            }
        }
    }

}
