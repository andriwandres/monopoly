namespace Monopoly.Presentation.Events.Players;

public sealed record PlayerJoinedEvent(string Nickname, string ColorHex);