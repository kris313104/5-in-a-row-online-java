package com.bpkb.fiveinrow.client.game;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class AIplayer {

    private Random random = new Random();

    public void makeMove(JButton[] buttons) {
        List<Integer> emptyIndices = new ArrayList<>();
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getText().equals("")) {
                emptyIndices.add(i);
            }
        }
        if (!emptyIndices.isEmpty()) {
            int randomIndex = emptyIndices.get(random.nextInt(emptyIndices.size()));
            buttons[randomIndex].setForeground(new Color(235, 219, 240));
            buttons[randomIndex].setText("O");
        }
    }
}
