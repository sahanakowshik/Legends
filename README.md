-----
***Name: Sahana Subramanya Kowshik***
***BUID: U43929102***

-----

***Classes***
1. Main: The main class that calls startGame of LegendsGame class.
2. RPGGame: An abstract class that stores common attributes to all role playing games.
3. LegendsGame: Implements main logic for the "Legends: Monsters and Heroes" game. Contains methods to start the game, create monsters and fight.
4. Player: An abstract class stores attributes and functions common to all players.
5. LegendsPlayer: Class to create players.
6. Heroes: An abstract class that stores common attributes and functions to all heroes.
7. Warrior: Class to create an instance of a warrior.
8. Sorcerer: Class to create an instance of a sorcerer.
9. Paladin: Class to create an instance of a paladin.
10. Monsters: An abstract class that stores common attributes and functions to all monsters.
11. Dragon: Class to create an instance of a dragon.
12. Exoskeleton: Class to create an instance of an exoskeleton.
13. Spirit: Class to create an instance of a spirit.
14. Cell: An abstract class that holds attributes to create a cell.
15. CellFactory: Used to implement the factory pattern to create a map using cells.
16. SafeCell: Class to create a safe/common cell.
17. MarketCell: Class to create a market cell.
18. InaccessibleCell: Class to create an inaccessible cell.
19. Board: An abstract class that holds attributes and functions common to all rpg games.
20. LegendsBoard: Class to create a map/board. Contains methods to create board, add players and move them.
21. Market: Class to create a market. Has methods to create and display all market items, and buy/sell items.
22. MarketItems: An abstract class that holds common attributes to all items.
23. Armory: Class to create armories.
24. Weapons: Class to create weapons.
25. Potions: Class to create potions.
26. Spell: An abstract class that holds common attributes to all spells.
27. FireSpell: Class to create a fire spell.
28. IceSpell: Class to create an ice spell.
29. LightningSpell: Class to create a lightning spell.

***Interfaces***
1. Game: Stores common attributes to all games.
2. isAccessible: To check if a cell is accessible.
3. isBuyableSellable: To check if an item can be bought or sold.
4. isCastable: To check if an item is castable. Implements default method use to cast a spell.
5. isDrinkable: To check if an item is drinkable. Implements default method use to drink the potion.
6. isUsable: To check if an item can be used.
7. MarketInterface: Used with Market class to implement Facade Design Pattern to create a market.

***Helper classes***
1. GameFunctions: Contains the functions that are used to drive the game. This includes getting input and getting boolean (of an event occurring) based on the given probability.
2. GameConstants: Contains the constants used in the card games. This includes a constant to set board size.
3. Music: Used to play music.
4. ASCIIArtGenerator: To create ASCII art. Taken reference from "https://www.quickprogrammingtips.com/java/ascii-art-generator-library-in-java.html".
5. Parser: Used to parse the input for config files and music files.

**Assumptions**
1. If all players die, they get revived with half their health.

**Design Patterns**
1. Factory Pattern: Factory pattern is implemented in the LegendsBoard class to create cells of type market, safe/common and inaccessible using CellFactory class.
2. Facade Pattern: Facade pattern is implemented to create the market. The main intention to use facade pattern here is to allow creation og market items only using market object. This is achieved using MarketInterface.

**Bonus Features**
1. Implemented 2 design patterns
2. Added ASCII text art
3. Added colour to the text
4. Added sound to the game
5. Implemented a parser class to parse the config files

###How to play
1. Once extracted run the follow commands in the extracted directory:
    1. cd out/production/ticTacToe
    2. java com.bu.cs.Main
2. Select the game by entering the option number
3. **Black Jack**: This is the orginal black jack
    1. Enter the number of players
    2. Enter the number of decks for the game
    3. Enter the details for each player, including money and bet amount
    4. Cards are dealt and the player can select if he needs to hit,stand,split or double down.
    5. Once the game is over, a summary is shown and a prompt to play a next game or exit is shown
    6. Once all the games are done, a prompt is shown for the game exit
4. **Trianta**: This is a variant of black jack
    1. Enter the number of players
    2. Enter the starting amount for each player
    3. Cards are dealt and the player can select if he needs to hit or stand. 
    4. Once the game is over, a summary is shown and a prompt to play a next game or exit is shown
    5. Once all the games are done, a prompt is shown for the game exit
    6. Once all the games are done a summary of the session is shown and the program exits

###Compile and run
**Extract the zip file into a folder.
All the below commands are run in the extracted directory.**
1. cd src
2. javac Main.java
3. java Main

***Note:***
1. The code only works with compile and run steps specified due to the path given to parse the config and music files. Does not run with Intellij or Eclipse.
2. Config files are present in Legends_Monsters_and_Heroes folder.