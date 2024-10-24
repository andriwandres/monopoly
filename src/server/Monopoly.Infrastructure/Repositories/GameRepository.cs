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

    public async Task<Game> Create()
    {
        var game = new Game
        {
            Status = GameStatus.Pending,
            CreatedAt = _dateProvider.Now()
        };

        do game.Code = GameCode.Create(new Random());
        while (_context.Games.Any(g => g.Code == game.Code));
        
        _context.Games.Add(game);
        await _context.SaveChangesAsync();
        
        return game;
    }
}