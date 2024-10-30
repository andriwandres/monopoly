using Monopoly.Presentation.Events.Dice;
using Monopoly.Presentation.Events.Players;

namespace Monopoly.Presentation.Hubs;

/// <summary>
/// Contains methods that perform actions on the client connected to a game
/// </summary>
public interface IGameClient
{
    Task DiceThrown(DiceThrownEvent dice);
    Task PlayerJoined(PlayerJoinedEvent player);
    Task PlayerLeft(PlayerLeftEvent player);
}
