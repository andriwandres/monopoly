namespace Monopoly.Presentation.Hubs;

/// <summary>
/// Contains methods that are available for connected clients
/// </summary>
internal interface IGameServer
{
    Task ThrowDice();
}