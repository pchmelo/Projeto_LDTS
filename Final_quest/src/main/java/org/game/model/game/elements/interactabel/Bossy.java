package org.game.model.game.elements.interactabel;

import org.game.model.game.elements.Element;
import org.game.rpg_rules.dialogue.Dialogue;

public class Bossy extends Element {
    public Bossy(int x, int y, Dialogue dialogue, String type, char desenho, String cor, String backCor) {
        super(x, y, dialogue, type, desenho, cor, backCor);
    }
}