using Monopoly.Domain.Games;
using Monopoly.Domain.Players;

namespace Monopoly.Domain.Properties;

public sealed class PropertyGame
{
    public int PropertyGameId { get; set; }
    public int PropertyId { get; set; }
    public int GameId { get; set; }
    public int OwnerPlayerId { get; set; }
    
    public int NumberOfHousesBuilt { get; set; }
    public bool IsMortgaged { get; set; }

    // Navigation Properties
    public Property Property { get; set; }
    public Game Game { get; set; }
    public Player Owner { get; set; }
}