using Microsoft.EntityFrameworkCore;
using Monopoly.Application.Games;
using Monopoly.Domain.Common;
using Monopoly.Domain.Games;
using Monopoly.Infrastructure.Database;

namespace Monopoly.Infrastructure.Repositories;

internal sealed class GameRepository : IGameRepository
{
    private readonly MonopolyDbContext _context;
    private readonly IDateProvider _dateProvider;

    public GameRepository(MonopolyDbContext context, IDateProvider dateProvider)
    {
        _context = context;
        _dateProvider = dateProvider;
    }

    public async Task<Game> FindByCode(string gameCode)
    {
        return await _context.Games.SingleAsync(game => game.Code == gameCode);
    }

    public async Task<Game> Create()
    {
        var game = new Game
        {
            Code = await GetUniqueGameCode(),
            Status = GameStatus.Pending,
            CreatedAt = _dateProvider.Now(),
        };

        await _context.Games.AddAsync(game);
        await _context.SaveChangesAsync();

        return game;
    }

    private async Task<string> GetUniqueGameCode()
    {
        string gameCode;
        
        do gameCode = GameCode.Create(new Random());
        while (await _context.Games.AnyAsync(g => g.Code == gameCode));

        return gameCode;
    }
}
