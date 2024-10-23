using Monopoly.Domain.Games;
using Monopoly.Domain.Players;

namespace Monopoly.Domain.Transactions;

public sealed class Transaction
{
    public int TransactionId { get; set; }
    public int GameId { get; set; }
    
    public int? FromPlayerId { get; set; }
    public int? ToPlayerId { get; set; }

    public int Amount { get; set; }
    public TransactionType Type { get; set; }
    
    public DateTime CreatedAt { get; set; }

    // Navigation Properties
    public Game Game { get; set; }
    public Player FromPlayer { get; set; }
    public Player ToPlayer { get; set; }
}
