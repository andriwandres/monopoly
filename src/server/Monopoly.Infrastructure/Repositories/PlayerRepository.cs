using Microsoft.EntityFrameworkCore;
using Monopoly.Application.Games;
using Monopoly.Application.Players;
using Monopoly.Domain.Common;
using Monopoly.Domain.Players;
using Monopoly.Infrastructure.Database;

namespace Monopoly.Infrastructure.Repositories;

internal sealed class PlayerRepository : IPlayerRepository
{
    private readonly MonopolyDbContext _context;
    private readonly IDateProvider _dateProvider;

    public PlayerRepository(MonopolyDbContext context, IDateProvider dateProvider)
    {
        _context = context;
        _dateProvider = dateProvider;
    }

    public async Task<bool> Exists(int gameId, string nickname)
    {
        return await _context.Players.AnyAsync(player => 
            player.GameId == gameId && 
            player.Nickname == nickname
        );
    }

    public async Task<Player> Create(CreatePlayerDto request)
    {
        var player = new Player
        {
            GameId = request.GameId,
            Nickname = request.Nickname,
            ColorHex = request.ColorHex,
            Money = Player.StartingMoney,
            Position = Player.StartingPosition,
            CreatedAt = _dateProvider.Now(),
            TurnOrder = await GetTurnOrder(request.GameId)
        };

        await _context.Players.AddAsync(player);
        await _context.SaveChangesAsync();
        
        return player;
    }

    private async ValueTask<int> GetTurnOrder(int gameId)
    {
        int numberOfPlayersInGame = await _context.Players
            .CountAsync(player => player.GameId == gameId);
        
        return numberOfPlayersInGame + 1;
    }
}
