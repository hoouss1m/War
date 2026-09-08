class War {
  private String name;
  private int health;
  private int maxHealth;
  private int damage;
  private int heal;

  War(String name, int health, int damage, int heal) {
    this.name = name;
    this.health = health;
    this.maxHealth = health;
    this.damage = damage;
    this.heal = heal;
  }

  // this function is to prove the hero is alive
  // if he is dead the function quite automatically
  boolean isAlive() {
    if (this.health > 0) {
      return true;
    } else {
      return false;
    }
  }

  // Attack function
  void attack(War enemy) {
    if (isAlive()) {
      enemy.health -= this.damage;
    } else {
      System.out.println(this.name + "is already defeated.");
      return;
    }
    System.out.println("The " + this.name + " Attacked The " + enemy.name);
    System.out.println("Amount of Damage : -" + this.damage + "HP");
    System.out.println("The health of " + enemy.name + " will be " + enemy.health + "HP");
    System.out.println();
    if (enemy.health <= 0) {
      enemy.health = 0;
      System.out.println("The " + enemy.name + " is defeated.");
    }
  }

  // heal function
  void heal() {

    if (this.health < this.maxHealth && this.health > 0) {

      this.health += this.heal;

      if (this.health > this.maxHealth) {

        this.health = this.maxHealth;

      }

      System.out.println(this.name + " healed himself");
      System.out.println("Amount of Heal : +" + this.heal + "HP");
      System.out.println(this.name + " Health will be " + this.health + "HP");
      System.out.println("");

    }

  }

  // disply the battel in the terminal
  void displayInfo() {
    System.out.println("Name : The " + name + "   " + "Health : " + health + " HP");
    System.out.println();
    System.out.println("Damage : " + damage + "   " + "Amount of heal : " + heal);
    System.out.println();
  }

  public static void main(String[] args) {

    War h1 = new War("Knight", -50, 35, 10);
    War h2 = new War("Wizard", 80, 20, 50);
    War h3 = new War("Dragon", 150, 50, 30);

    System.out.println("");
    System.out.println("The Heroes before The Battel :");
    System.out.println("");
    h1.displayInfo();
    h2.displayInfo();
    h3.displayInfo();

    System.out.println("|====> The Battel : ");
    System.out.println("");
    h1.attack(h3);
    h3.attack(h1);
    h3.attack(h2);
    h2.heal();
    h1.attack(h3);
    h2.attack(h3);
    h3.attack(h1);
    System.out.println("");
    System.out.println("|====> End the Battel : ");

    System.out.println("");
    System.out.println("The Heroes after The Battel :");
    System.out.println("");
    h1.displayInfo();
    h2.displayInfo();
    h3.displayInfo();

  }
}