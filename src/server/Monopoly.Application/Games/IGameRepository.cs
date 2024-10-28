using Monopoly.Domain.Games;

namespace Monopoly.Application.Games;

public interface IGameRepository
{
    Task<Game> FindByCode(string gameCode);
    Task<Game> Create();
}
