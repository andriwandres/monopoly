using Microsoft.AspNetCore.SignalR;
using Monopoly.Presentation.Hubs;

namespace Monopoly.Presentation.Extensions;

internal static class HubCallerContextExtensions
{
    public static SocketConnectionData ReadConnectionData(this HubCallerContext context)
    {
        var httpContext = context.GetHttpContext()!;

        return new SocketConnectionData(
            context.ConnectionId,
            httpContext.Request.Query["gameCode"]!,
            httpContext.Request.Query["nickname"]!,
            httpContext.Request.Query["color"]!
        );
    }
}