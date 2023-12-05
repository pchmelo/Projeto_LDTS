package org.game.model.game.map;

import org.game.model.Dialogue.Dialogue;
import org.game.model.game.elements.*;

import java.io.IOException;
import java.util.List;

public abstract class VillageBuilder {

    protected VillageBuilder() throws IOException {
    }

    public Village createVillage() throws IOException {
        Village village = new Village(getWidth(), getHeight());


        village.setHero(createHero());
        village.setWalls(createWalls());
        village.setNPC(createNPC());
        village.setDoors(createDoor());
        village.setStairs(createStairs());
        village.setDialogue1(createDialogue1());
        village.setDialogue2(createDialogue2());
        village.setDialogue3(createDialogue3());
        village.setDialogue4(createDialogue4());
        village.setDialogue5(createDialogue5());
        village.setChests(createChests());
        village.setSigns(createSigns());
        return village;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract Hero createHero() throws IOException;

    protected abstract List<NPC> createNPC();
    protected abstract List<Door> createDoor();
    protected abstract List<Stairs> createStairs();


    protected abstract List<DialogueT> createDialogue1();
    protected abstract List<DialogueT> createDialogue2();
    protected abstract List<DialogueT> createDialogue3();
    protected abstract List<DialogueT> createDialogue4();
    protected abstract List<DialogueT> createDialogue5();

    protected abstract List<Chest> createChests();

    protected abstract List<Sign> createSigns();
}

