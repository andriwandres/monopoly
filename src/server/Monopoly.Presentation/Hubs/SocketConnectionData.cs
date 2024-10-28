namespace Monopoly.Presentation.Hubs;

internal sealed record SocketConnectionData(
    string ConnectionId, 
    string GameCode, 
    string Nickname,
    string ColorHex
);
