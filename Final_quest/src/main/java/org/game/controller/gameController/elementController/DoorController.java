package org.game.controller.gameController.elementController;

import org.game.Game;
import org.game.controller.gameController.InteractionController;
import org.game.gui.GUI;
import org.game.model.menu.InteractionMenu;

import java.io.IOException;
import java.net.URISyntaxException;

public class DoorController extends InteractionController {
    public DoorController(InteractionMenu interactionMenu) {
        super(interactionMenu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedYes()) {
                    game.previousState();

                    }
                else if (getModel().isSelectedNo()) {

                    game.previousState();
             }

        }
    }


}