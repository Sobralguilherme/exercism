class Fighter {

    boolean isVulnerable() {
        return true;
    }

    int getDamagePoints(Fighter fighter) {
        return 1;
    }
}

class Warrior extends Fighter {

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    boolean isVulnerable() {
        // A Warrior is never vulnerable
        return false;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        // Deals 10 damage if target is vulnerable, else 6
        return fighter.isVulnerable() ? 10 : 6;
    }
}

class Wizard extends Fighter {
    private boolean spellPrepared = false;

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    public void prepareSpell() {
        spellPrepared = true;
    }

    @Override
    boolean isVulnerable() {
        // Vulnerable unless a spell is prepared
        return !spellPrepared;
    }

    @Override
    int getDamagePoints(Fighter fighter) {
        // Deals 12 damage if spell is prepared, else 3
        return spellPrepared ? 12 : 3;
    }
}