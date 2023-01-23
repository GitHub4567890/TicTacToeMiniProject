public class WinCondition
{
  private int[] winningSpaces;
  
  public WinCondition(int space1, int space2, int space3)
  {
    winningSpaces = new int[3];
    winningSpaces[0] = space1;
    winningSpaces[1] = space2;
    winningSpaces[2] = space3;
  }

  public WinCondition(int space1, int space2, int space3, int space4)
  {
    winningSpaces = new int[4];
    winningSpaces[0] = space1;
    winningSpaces[1] = space2;
    winningSpaces[2] = space3;
    winningSpaces[3] = space4;
  }

  public WinCondition(int space1, int space2, int space3, int space4, int space5)
  {
    winningSpaces = new int[5];
    winningSpaces[0] = space1;
    winningSpaces[1] = space2;
    winningSpaces[2] = space3;
    winningSpaces[3] = space4;
    winningSpaces[4] = space5;
  }

  public WinCondition(int space1, int space2, int space3, int space4, int space5, int space6)
  {
    winningSpaces = new int[6];
    winningSpaces[0] = space1;
    winningSpaces[1] = space2;
    winningSpaces[2] = space3;
    winningSpaces[3] = space4;
    winningSpaces[4] = space5;
    winningSpaces[5] = space6;
  }
  
  public int[] getWinningSpaces()
  {
    return winningSpaces;
  }
}