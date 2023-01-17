public class Player
{
  // instance variable marked as FINAL
  // once it's set in the constructor, it stays!
	private final String symbol;

	public Player (String symbol)
	{
		this.symbol = symbol;
	}
	
	public String getSymbol()
  {
    return symbol;
  }
}