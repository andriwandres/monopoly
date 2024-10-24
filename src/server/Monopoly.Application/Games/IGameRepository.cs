using Monopoly.Domain.Games;

namespace Monopoly.Application.Games;

public interface IGameRepository
{
    Task<Game> Create();
}