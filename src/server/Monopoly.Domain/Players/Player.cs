namespace Monopoly.Domain.Players;

public sealed class Player
{
    public int PlayerId { get; set; }
    public int GameId { get; set; }

    public string Nickname { get; set; } = null!;
    public string ColorHex { get; set; } = null!;
    
    public int Money { get; set; }
    public int Position { get; set; }
    public bool IsInJail { get; set; }
    public int NumberOfTurnsInJail { get; set; }
    public int TurnOrder { get; set; }
    
    public DateTime CreatedAt { get; set; }
}
