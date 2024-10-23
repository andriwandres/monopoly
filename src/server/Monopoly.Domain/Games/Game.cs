namespace Monopoly.Domain.Games;

public sealed class Game
{
    public int GameId { get; set; }
    public string Code { get; set; } = null!;
    
    public GameStatus Status { get; set; }
    public int CurrentTurnPlayerId { get; set; }
    
    public DateTime CreatedAt { get; set; }
}
