using Microsoft.AspNetCore.SignalR;
using Monopoly.Application.Games;
using Monopoly.Application.Players;
using Monopoly.Domain.Die;
using Monopoly.Domain.Players;
using Monopoly.Presentation.Events.Dice;
using Monopoly.Presentation.Extensions;

namespace Monopoly.Presentation.Hubs;

internal sealed class GameHub : Hub<IGameClient>, IGameServer
{
    private readonly IPlayerRepository _playerRepository;
    private readonly IGameRepository _gameRepository;

    public GameHub(IPlayerRepository playerRepository, IGameRepository gameRepository)
    {
        _playerRepository = playerRepository;
        _gameRepository = gameRepository;
    }

    public override async Task OnConnectedAsync()
    {
        var connection = Context.ReadConnectionData();
        
        var game = await _gameRepository.FindByCode(connection.GameCode);
        var playerExists = await _playerRepository.Exists(game.GameId, connection.Nickname);

        if (playerExists)
        {
            // re-join
        }
        
        // join for the first time
        await _playerRepository.Create(new CreatePlayerDto(
            game.GameId,
            connection.Nickname,
            connection.ColorHex
        ));
        
        await Groups.AddToGroupAsync(connection.ConnectionId, connection.GameCode);
    }

    public override async Task OnDisconnectedAsync(Exception? exception)
    {
        var connection = Context.ReadConnectionData();
        await Groups.RemoveFromGroupAsync(connection.ConnectionId, connection.GameCode);
    }

    public async Task ThrowDice()
    {
        var connection = Context.ReadConnectionData();
        var (die1, die2) = Dice.Throw(new Random());
        
        var gameClients = Clients.Group(connection.GameCode);
        
        await gameClients.DiceThrown(new DiceThrownEvent(connection.Nickname, die1, die2));
    }
}
