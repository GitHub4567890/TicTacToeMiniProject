import java.util.Scanner;
public class Board
{
  private Space[] spaces;
  private WinCondition[] winningConfigs;
  private int boardSize;
  private int boardLength;

  /**
   * Constructs 9 new Space objects and adds them to the spaces array.
   * Also sets up the 8 winning conditions for tic-tac-toe.
   */
	public Board()
	{
    Scanner scan = new Scanner(System.in);
    System.out.print("How many spaces? (Enter 9 for: 3x3, Enter 16 for: 4x4, Enter 25 for: 5x5, Enter 36 for: 6x6): ");
    boardSize = scan.nextInt();
    while (boardSize != 9 && boardSize != 16 && boardSize != 25 && boardSize != 36) {
        System.out.print("Please enter one of the choices: ");
        boardSize = scan.nextInt();
    }
    boardLength = (int) Math.sqrt(boardSize);
    spaces = new Space[boardSize];
    for (int i = 0; i < spaces.length; i++)
    {
      spaces[i] = new Space();
    }

        if (boardLength == 3) {
            winningConfigs = new WinCondition[8];
        } else if (boardLength == 4) {
            winningConfigs = new WinCondition[10];
        } else if (boardLength == 5) {
            winningConfigs = new WinCondition[12];
        } else if (boardLength == 6) {
            winningConfigs = new WinCondition[14];
        }

    int counter = 0;
    for (int i = 0; i <= boardLength * 3; i += boardLength) {
        if (boardLength == 3) {
            winningConfigs[counter] = new WinCondition(i, i + 1, i + 2);
        } else if (boardLength == 4) {
            winningConfigs[counter] = new WinCondition(i, i + 1, i + 2, i + 3);
            System.out.println(i+", "+i+" + 1, "+i+" + 2, "+i+" + 3");
        } else if (boardLength == 5) {
            winningConfigs[counter] = new WinCondition(i, i + 1, i + 2, i + 3, i + 4);
            System.out.println(i+", "+i+" + 1, "+i+" + 2, "+i+" + 3"+i+" + 4");
        } else if (boardLength == 6) {
            winningConfigs[counter] = new WinCondition(i, i + 1, i + 2, i + 3, i + 4, i + 5);
            System.out.println(i+", "+i+" + 1, "+i+" + 2, "+i+" + 3"+i+" + 4"+i+" + 5");

        }
        counter++;
    }
//    counter++;
    System.out.println(counter);

        for (int i = 0; i <= boardLength; i += 1) {
            if (boardLength == 3) {
                winningConfigs[counter] = new WinCondition(i, i + boardLength, (i + boardLength * 2));
                System.out.println(i + "," + i + boardLength + ",(" + i + boardLength + "* 2)");
                winningConfigs[7] = new WinCondition(0, 4, 8);
            } else if (boardLength == 4) {
                winningConfigs[counter] = new WinCondition(i, i + boardLength, (i + boardLength * 2), (i + boardLength * 3));
                System.out.println(i + "," + i + boardLength + ",(" + i + boardLength + "* 2)" + ",(" + i + boardLength + "* 3)");
                winningConfigs[9] = new WinCondition(0, 5, 10, 15);
            } else if (boardLength == 5) {
                winningConfigs[counter] = new WinCondition(i, i + boardLength, (i + boardLength * 2), (i + boardLength * 3), (i + boardLength * 4));
                System.out.println(i + "," + i + boardLength + ",(" + i + boardLength + "* 2)" + ",(" + i + boardLength + "* 3)" + ",(" + i + boardLength + "* 4)");
                winningConfigs[11] = new WinCondition(0, 6, 12, 18, 24);
            } else if (boardLength == 6) {
                winningConfigs[counter] = new WinCondition(i, i + boardLength, (i + boardLength * 2), (i + boardLength * 3), (i + boardLength * 4), (i + boardLength * 5));
                System.out.println(i + "," + i + boardLength + ",(" + i + boardLength + "* 2)" + ",(" + i + boardLength + "* 3)" + ",(" + i + boardLength + "* 4)" + ",(" + i + boardLength + "* 5)");
                winningConfigs[13] = new WinCondition(0, 7, 14, 21, 28, 35);
            }
            counter++;
        }

        for (int i = 0; i <= winningConfigs.length - 1; i++) {
            System.out.print(winningConfigs[i].getWinningSpaces()[0] + ", ");
            System.out.print(winningConfigs[i].getWinningSpaces()[1] + ", ");
            System.out.print(winningConfigs[i].getWinningSpaces()[2] + ", ");
            System.out.print(winningConfigs[i].getWinningSpaces()[3] + ", ");
            System.out.println();

        }

//    winningConfigs = new WinCondition[8];
//    winningConfigs[0] = new WinCondition(0, 1, 2);
//    winningConfigs[1] = new WinCondition(3, 4, 5);
//    winningConfigs[2] = new WinCondition(6, 7, 8);
//    winningConfigs[3] = new WinCondition(0, 3, 6);
//    winningConfigs[4] = new WinCondition(1, 4, 7);
//    winningConfigs[5] = new WinCondition(2, 5, 8);
//    winningConfigs[6] = new WinCondition(0, 4, 8);
//    winningConfigs[7] = new WinCondition(2, 4, 6);
	}

  // getter method; note that there is
  // a parameter, which allows caller to specify
  // which specific Space (of the 9) to return
  public Space getSpace(int idx)
  {
    if (idx >= 0 && idx < spaces.length)
    {
      return spaces[idx];
    }
    return null;
  }

  public int getBoardLength() {
        return boardLength;
  }

  /**
   * Draws the tic-tac-toe board so that the user can see what is happening.
   * The empty board should look like this:
   *
   *   1|2|3
   *   -----
   *   4|5|6
   *   -----
   *   7|8|9
   *
   * As the players choose space numbers, those spaces will be filled in with Xs and Os.
   *
   *   O|2|3
   *   -----
   *   4|X|6
   *   -----
   *   7|8|9
   *
   * This method goes through each space on the board and checks for BLANKS.
   * If the space is BLANK, it prints the appropriate number.
   * Otherwise, it prints the appropriate symbol.
   */
	public void drawBoard()
	{
    System.out.println();

		for (int i = 0; i < boardSize; i++)
		{
			Space space = spaces[i];

			if (space.getSymbol() == Space.BLANK)
      {
        // number them 1 thru boardSize
          if (i + 1 <= 9) {
              System.out.print(i + 1 + " ");
          } else {
              System.out.print(i + 1);
          }
      }
			else
      {
				System.out.print(space.getSymbol());
      }

      // print a horizontal divider after each set of 3
			if((i + 1) % boardLength == 0)
      {
				System.out.println("\n-----");
      }
      // print a vertical divider between each space
			else
      {
				System.out.print("|");
      }
		}

		System.out.println();
	}

  /**
   * Updates a space based on a player's move by changing it from a blank space to either
   * a an X or O (whichever symbol is associated with player)
   * The method uses an integer (spaceIdx) to determine which space is going to be updated.
   * Method returns TRUE if the space was successfully "occupied", which occurs via the occupySpace
   * method on the space object; if the space was NOT successfully occupied (either because the selected
   * space was outside the 1-9 range, OR the space was ALREADY occupied by the opposite player), then
   * return false to indicate the space was NOT occupied.
   *
   * @param spaceIdx  the index of the space to be occupied by player.
   * @param player  the Player taking the turn and attempting to "occupy" the space.
   * @return  true if the move was successful and the space occupied; return false otherwise.
   */
	public boolean recordMove(int spaceIdx, Player player)
	{
    // since spaces are numbered 1-9, subtract 1 to correlate to 0-8 index range
    int adjustedSpace = spaceIdx - 1;

    // if user chooses a space between 1 and 9, try to occupy it, which updates
    // the symbol and returns true if the space is currently a numbered "blank" space
    if (adjustedSpace >= 0 && adjustedSpace < spaces.length)
    {
      boolean spaceOccupied = spaces[adjustedSpace].occupySpace(player.getSymbol());
      return spaceOccupied;
    }
    return false;
	}

  /**
   * Uses the checkConfiguration() method to determine whether or not there is a winner.
   * By checking each of the various WinConditions into checkConfiguration,
   * this method will know whether or not the game has been won, and if so, by who (X or O).
   *
   * @return  if there IS a winning condition on the board, appropriates returns either "X" or "O",
              whichever the winning symbol is; if there is NO winning condition and no
              current winner, this method returns BLANK!
   */
	public String checkWinner() {
        for (int i = 0; i <= winningConfigs.length - 1; i++)
            {
                WinCondition config = winningConfigs[i];
                // if a player HAS achieved a particular win configuration on the board...

                System.out.print(config.getWinningSpaces()[0] + ", ");
                System.out.print(config.getWinningSpaces()[1] + ", ");
                System.out.print(config.getWinningSpaces()[2] + ", ");
                System.out.print(config.getWinningSpaces()[3] + ", ");
                System.out.println();

                if (checkConfiguration(config)) {
                    // if the config is a winning condition, then all three Spaces
                    // making up that configuration have the same symbol (i.e. 3 X's in a row
                    // or 3 O's in a row), so arbitrarily choose the first int value
                    // in the array (index 0) to get the winning symbol
                    int spaceWithWinningSymbol = config.getWinningSpaces()[0];

                    String winningSymbol = spaces[spaceWithWinningSymbol].getSymbol();

                    return winningSymbol;
                }

            }
        return Space.BLANK;
    }

  /**
   * Determines whether or not all 3 received spaces have the same symbol.
   *
   * @param comboToCheck  The WinCondition containing the three indices of a win condition
   * @return  true if the spaces all have the same symbol, i.e. it's a "WIN"
   */
	public boolean checkConfiguration(WinCondition comboToCheck)
	{
    int[] winningSpaces = comboToCheck.getWinningSpaces();
    if (boardLength == 3) {
        int s1 = winningSpaces[0];
        int s2 = winningSpaces[1];
        int s3 = winningSpaces[2];
        return spaces[s1].getSymbol() == spaces[s2].getSymbol() && spaces[s1].getSymbol() == spaces[s3].getSymbol();

    }
    if (boardLength == 4) {
        int s1 = winningSpaces[0];
        int s2 = winningSpaces[1];
        int s3 = winningSpaces[2];
        int s4 = winningSpaces[3];
        return spaces[s1].getSymbol() == spaces[s2].getSymbol() && spaces[s1].getSymbol() == spaces[s3].getSymbol() && spaces[s1].getSymbol() == spaces[s4].getSymbol();

    }
    if (boardLength == 5) {
        int s1 = winningSpaces[0];
        int s2 = winningSpaces[1];
        int s3 = winningSpaces[2];
        int s4 = winningSpaces[3];
        int s5 = winningSpaces[4];
        return spaces[s1].getSymbol() == spaces[s2].getSymbol() && spaces[s1].getSymbol() == spaces[s3].getSymbol() && spaces[s1].getSymbol() == spaces[s4].getSymbol() && spaces[s1].getSymbol() == spaces[s5].getSymbol();

    }
    if (boardLength == 6) {
        int s1 = winningSpaces[0];
        int s2 = winningSpaces[1];
        int s3 = winningSpaces[2];
        int s4 = winningSpaces[3];
        int s5 = winningSpaces[4];
        int s6 = winningSpaces[5];
        return spaces[s1].getSymbol() == spaces[s2].getSymbol() && spaces[s1].getSymbol() == spaces[s3].getSymbol() && spaces[s1].getSymbol() == spaces[s4].getSymbol() && spaces[s1].getSymbol() == spaces[s5].getSymbol() && spaces[s1].getSymbol() == spaces[s6].getSymbol();

    }
        return false;
    }


   /**
   *Determines whether or not the board is full (has no BLANK spaces).
   *
   *@return True if there are no BLANKs in any spaces.
   */
	public boolean isFull()
	{
		for (int i = 0; i < spaces.length; i++)
    {
	    if(spaces[i].getSymbol() == Space.BLANK)
   		{
        return false;
      }
    }
		return true;
	}
}
