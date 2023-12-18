package org.game.rpg_elements.status.ataque;

import org.game.model.battle.battleElements.Hero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Learn_Ataque {
    private static Integer num_ataques = 6;
    public List<Ataque> aprender(Hero hero) throws IOException {
        List<Ataque> res = new ArrayList<>();
        Ataque ataque;

        for(int i = 1; i <= num_ataques; i++){
            ataque = new LoaderAtaque().renderAtaque(String.valueOf(i));
            if(tem_ataque(hero, ataque)){
                if(hero.getStatus().getAtributos_real().learn_ataque(ataque)){
                    res.add(ataque);
                }
            }
        }

        return  res;
    }

    private boolean tem_ataque(Hero hero, Ataque ataque){
        boolean flag = true;

        for(Ataque ataque1 : hero.getStatus().getAtaques()){
            if(ataque1.getNome().equals(ataque.getNome())){
                flag = false;
                break;
            }
        }

        return flag;
    }
}