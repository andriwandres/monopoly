namespace Monopoly.Domain.Dice;

public static class Dice
{
    private const int MinValue = 1;
    private const int MaxValue = 6;
    
    public static (int die1, int die2) Throw(Random random) => (
        ThrowDie(random), 
        ThrowDie(random)
    );
    
    private static int ThrowDie(Random random) => random.Next(MinValue, MaxValue + 1);
}
