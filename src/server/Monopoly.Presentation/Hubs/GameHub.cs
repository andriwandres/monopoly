using Microsoft.AspNetCore.SignalR;
using Monopoly.Domain.Dice;
using Monopoly.Presentation.Events.Dice;

namespace Monopoly.Presentation.Hubs;

internal sealed class GameHub : Hub<IGameHub>
{
    public override async Task OnConnectedAsync()
    {
        var connection = ReadConnectionData();
        await Groups.AddToGroupAsync(connection.ConnectionId, connection.RoomId);
    }

    public override async Task OnDisconnectedAsync(Exception? exception)
    {
        var connection = ReadConnectionData();
        await Groups.RemoveFromGroupAsync(connection.ConnectionId, connection.RoomId);
    }

    public async Task ThrowDice()
    {
        var connection = ReadConnectionData();
        var (die1, die2) = Dice.Throw(new Random());

        var roomClients = Clients.Group(connection.RoomId);
        
        await roomClients.DiceThrown(new DiceThrownEvent(connection.Nickname, die1, die2));
    }

    private SocketConnectionData ReadConnectionData()
    {
        var httpContext = Context.GetHttpContext()!;

        return new SocketConnectionData(
            Context.ConnectionId,
            httpContext.Request.Query["roomId"]!,
            httpContext.Request.Query["nickname"]!
        );
    }
}

