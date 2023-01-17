public class WinCondition
{
  private int[] winningSpaces;
  private String hey;
  
  public WinCondition(int space1, int space2, int space3)
  {
    winningSpaces = new int[3];
    winningSpaces[0] = space1;
    winningSpaces[1] = space2;
    winningSpaces[2] = space3;
  }
  
  public int[] getWinningSpaces()
  {
    return winningSpaces;
  }
}