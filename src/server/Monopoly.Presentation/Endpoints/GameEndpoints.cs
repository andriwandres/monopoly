using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Routing;
using Monopoly.Application.Games;
using Monopoly.Domain.Games;

namespace Monopoly.Presentation.Endpoints;

internal static class GameEndpoints
{
    public static void MapGameEndpoints(this IEndpointRouteBuilder app)
    {
        // Create game
        app.MapPost("/game", async (IGameRepository gameRepository) =>
        {
            Game game = await gameRepository.Create();
            return Results.Ok(game.Code);
        });
    }
}
