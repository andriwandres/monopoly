using Monopoly.Domain.Players;

namespace Monopoly.Application.Players;

public interface IPlayerRepository
{
    Task<bool> Exists(int gameId, string nickname);
    Task<Player> Create(CreatePlayerDto request);
}
