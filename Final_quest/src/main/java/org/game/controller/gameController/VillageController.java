package org.game.controller.gameController;

import org.game.model.game.map.Village;
import org.game.Game;
import org.game.gui.GUI;

import java.io.IOException;

public class VillageController extends GameController{
    private final HeroController heroController;
    private final DialogueController dialogueController;
    public VillageController(Village village) {
        super(village);
        this.heroController = new HeroController(village);
        this.dialogueController = new DialogueController(village);

    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (action == GUI.ACTION.QUIT){
            System.exit(0);
        }
        else{
            heroController.step(game, action, time);
            dialogueController.step(game,action,time);

        }

    }
}