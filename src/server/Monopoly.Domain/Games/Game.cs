using Monopoly.Domain.Players;
using Monopoly.Domain.Properties;
using Monopoly.Domain.Transactions;

namespace Monopoly.Domain.Games;

public sealed class Game
{
    public int GameId { get; set; }
    public int? CurrentTurnPlayerId { get; set; }
    
    public string Code { get; set; } = null!;
    public GameStatus Status { get; set; }
    
    public DateTime CreatedAt { get; set; }
    
    // Navigation Properties
    public Player CurrentTurnPlayer { get; set; }
    public ICollection<Player> Players { get; set; } = new HashSet<Player>();
    public ICollection<PropertyGame> Properties { get; set; } = new HashSet<PropertyGame>();
    public ICollection<Transaction> Transactions { get; set; } = new HashSet<Transaction>();
}
