using Monopoly.Domain.Games;
using Monopoly.Domain.Properties;
using Monopoly.Domain.Transactions;

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

    // Constants
    public const int StartingMoney = 1500;
    public const int StartingPosition = 1;
    
    // Navigation Properties
    public Game Game { get; set; }
    public ICollection<PropertyGame> OwnedProperties { get; set; } = new HashSet<PropertyGame>();
    public ICollection<Transaction> InitiatedTransactions { get; set; } = new HashSet<Transaction>();
    public ICollection<Transaction> ReceivedTransactions { get; set; } = new HashSet<Transaction>();
}
