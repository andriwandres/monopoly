namespace Monopoly.Domain.Players;

public sealed record CreatePlayerDto(
    int GameId,
    string Nickname,
    string ColorHex
);