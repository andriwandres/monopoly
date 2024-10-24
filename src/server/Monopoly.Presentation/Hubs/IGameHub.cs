using Monopoly.Presentation.Events.Dice;

namespace Monopoly.Presentation.Hubs;

public interface IGameHub
{
    Task DiceThrown(DiceThrownEvent dice);
}
