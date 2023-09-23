package myproject;
import java.util.Scanner;
import java .util.Random;

public class textbasedgame {
	public static void main(String[] args) {

		Random rand=new Random();
		Scanner s=new Scanner(System.in);
		String[] enemies= {"Skeleton", "Zombie", "Dragon", "Assassin", "Warrior", "Mummy"};
		int maxenemyhealth=75;
		int enemyattackdamage=25;
		int health=100;
		int attackdamage=50;
		int numhealthpotions=3;
		int healthpotionhealamount=30;
		int healthpotiondropchance=50;
		boolean running=true;
		System.out.println("Welcome To The Dungeon!");
		GAME:
			while(running) {
				System.out.println("----------------------------------------------");
				int enemyhealth=rand.nextInt(maxenemyhealth);
				String enemy=enemies[rand.nextInt(enemies.length)];
				System.out.println("\t#"+ enemy+" has appeared!#\n");
				while(enemyhealth>0) {
					System.out.println("\t Your HP: "+ health);
					System.out.println("\t"+enemy+"'s HP: "+enemyhealth);
					System.out.println("\n \t What would you like to do?");
					System.out.println("\t1. Attack");
					System.out.println("\t2. Drink health potion");
					System.out.println("\t3. Run");
					String input=s.nextLine();
					switch(input) {
					case "1":
						int damagedealt=rand.nextInt(attackdamage);
						int damagetaken=rand.nextInt(enemyattackdamage);
						enemyhealth -=damagedealt;
						health -=damagetaken;
						System.out.println("\t> You Strike the "+enemy+" for "+damagedealt+" damage.");
						System.out.println("\t> You received "+damagetaken+" in retaliation!");
						if(health<1) {
							System.out.println("\t You have taken too much damage, you are too weak to go on");
							break;
						}
						break;
					case "2":
						if(numhealthpotions>0) {
							health+=healthpotionhealamount;
							numhealthpotions--;
							System.out.println("\t> you drink health potion, healing yourself for "+ healthpotionhealamount+".");
							System.out.println("\t>  You now have "+ health+" HP.");
							System.out.println("\t> You have "+numhealthpotions+" health potions left \n");
						}
						else {
							System.out.println("you have no healthpotions left! defeat enemies for a chance");
						}
						break;
					case "3":
						System.out.println("\t You ran away from the "+ enemy + "!");
						continue GAME;

					default:
						System.out.println("Invalid command");
						break;
					}
				}
				if(health<1) {
					System.out.println("You limp out of the dungeon, weak from battle");
					break;
				}
				System.out.println("------------------------------------");
				System.out.println("# "+ enemy +"was defeated! #");
				System.out.println("You have"+health+" HP left. #");
				if(rand.nextInt(100)<healthpotiondropchance) {
					numhealthpotions++;
					System.out.println("# The "+ enemy+" dropped a health potion! #");
					System.out.println("# You now have "+ numhealthpotions+" health potion(s) #");
				}
					System.out.println("----------------------------------");
					System.out.println("what would you like to do now?");
					System.out.println("1. Continue Fighting");
					System.out.println("2. exit dungeon");
					String ans=s.nextLine();

					while(!ans.equals("1") && !ans.equals("2")) {
						System.out.println("Invalid command");
						ans=s.nextLine();
					}
					if(ans.equals("1")) {
						System.out.println("You continue on your adventure!");
					}
					else if(ans.equals("2")) {
						System.out.println("You exit the dungeon, successfully from your adventure");
						break;
					}
			}
				
				System.out.println("########################");
				System.out.println("#THANKS FOR PLAYING!#");
				System.out.println("########################");
			
	}


}
