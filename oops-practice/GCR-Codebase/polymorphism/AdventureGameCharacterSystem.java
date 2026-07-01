import java.util.Scanner;

class GameCharacter {
    protected String characterName;
    protected int health;
    protected int attackPower;

    public GameCharacter(String characterName, int health, int attackPower) {
        this.characterName = characterName;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void performAttack() {
        System.out.println(characterName + " attacks with power: " + attackPower);
    }

    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(characterName + " takes " + damage + " damage. Health: " + health);
    }

    public void displayInfo() {
        System.out.println("Name: " + characterName + " | Health: " + health + " | Attack: " + attackPower);
    }
}

class Warrior extends GameCharacter {
    private int armor;

    public Warrior(String characterName, int health, int attackPower, int armor) {
        super(characterName, health, attackPower);
        this.armor = armor;
    }

    @Override
    public void performAttack() {
        System.out.println("[WARRIOR] " + characterName + " performs a SWORD STRIKE with power: " + (attackPower + 20));
    }

    @Override
    public void takeDamage(int damage) {
        int reducedDamage = Math.max(damage - armor, 1);
        super.takeDamage(reducedDamage);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Warrior | Armor: " + armor);
    }
}

class Mage extends GameCharacter {
    private int manaPoints;

    public Mage(String characterName, int health, int attackPower, int manaPoints) {
        super(characterName, health, attackPower);
        this.manaPoints = manaPoints;
    }

    @Override
    public void performAttack() {
        System.out.println("[MAGE] " + characterName + " casts a FIREBALL spell with power: " + (attackPower + 30));
        manaPoints -= 10;
        System.out.println("Remaining Mana: " + manaPoints);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Mage | Mana: " + manaPoints);
    }
}

class Archer extends GameCharacter {
    private int arrows;

    public Archer(String characterName, int health, int attackPower, int arrows) {
        super(characterName, health, attackPower);
        this.arrows = arrows;
    }

    @Override
    public void performAttack() {
        System.out.println("[ARCHER] " + characterName + " shoots ARROWS with power: " + (attackPower + 15));
        arrows--;
        System.out.println("Arrows left: " + arrows);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Archer | Arrows: " + arrows);
    }
}

public class AdventureGameCharacterSystem {
    public static void startBattle(GameCharacter[] characters) {
        System.out.println("\n=== BATTLE STARTS ===\n");
        System.out.println("--- Initial Character Stats ---");
        for (GameCharacter character : characters) {
            character.displayInfo();
            System.out.println();
        }

        System.out.println("--- Battle Sequence ---");
        for (int round = 1; round <= 3; round++) {
            System.out.println("\n--- Round " + round + " ---");
            for (GameCharacter character : characters) {
                character.performAttack();
            }
        }

        System.out.println("\n=== BATTLE ENDS ===\n");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Adventure Game Character System ===\n");

        GameCharacter[] characters = new GameCharacter[5];
        characters[0] = new Warrior("Aragorn", 150, 50, 30);
        characters[1] = new Mage("Gandalf", 100, 70, 100);
        characters[2] = new Archer("Legolas", 120, 45, 50);
        characters[3] = new Warrior("Gimli", 140, 55, 35);
        characters[4] = new Mage("Saruman", 110, 75, 80);

        System.out.println("--- Characters in Game ---");
        for (int i = 0; i < characters.length; i++) {
            System.out.println("Character " + (i + 1) + ":");
            characters[i].displayInfo();
            System.out.println();
        }

        startBattle(characters);

        System.out.println("--- Character Statistics ---");
        int warriorCount = 0, mageCount = 0, archerCount = 0;
        for (GameCharacter character : characters) {
            if (character instanceof Warrior) {
                warriorCount++;
            } else if (character instanceof Mage) {
                mageCount++;
            } else if (character instanceof Archer) {
                archerCount++;
            }
        }

        System.out.println("Warriors: " + warriorCount);
        System.out.println("Mages: " + mageCount);
        System.out.println("Archers: " + archerCount);
        System.out.println("Total Characters: " + characters.length);

        sc.close();
    }
}
