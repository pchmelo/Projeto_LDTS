package org.game.controller.inventortController;

import org.game.Game;
import org.game.controller.Controller;
import org.game.gui.GUI;
import org.game.model.battle.menus.Receive;

import java.io.IOException;
import java.net.URISyntaxException;

public class ReceiveController extends Controller<Receive> {
    public ReceiveController(Receive model) {
        super(model);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException {
        switch (action) {
            case BACK, ESC,SELECT:
                game.notifySilence();
                game.previousState();
                game.notifySilence();
                game.previousState();
                game.notifySilence();
                game.previousState();

                break;

        }
    }
}