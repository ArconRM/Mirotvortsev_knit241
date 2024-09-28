package org.knit;

import org.knit.lab3.Mage;
import org.knit.lab3.PlayerFabric;
import org.knit.lab3.Priest;
import org.knit.lab3.WarriorTank;

public class Main {
    public static void main(String[] args) {
        PlayerFabric fabric = new PlayerFabric();

        WarriorTank warrior = fabric.createWarriorTank("Some Ork");
        warrior.move(10, 10);

        Mage mage = fabric.createMage("Some Mage");
        mage.move(10, 20);

        Priest priest = fabric.createPriest("Some Healer");
        priest.move(10, 20);

        warrior.attack(mage);
        priest.heal(mage);
        mage.castSpell(warrior);
        mage.castSpell(warrior);
        mage.castSpell(warrior);
        mage.castSpell(warrior);
        mage.castSpell(warrior);

        System.out.println(warrior);
    }
}
