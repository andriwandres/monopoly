using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Routing;
using Microsoft.Extensions.DependencyInjection;
using Monopoly.Presentation.Hubs;

namespace Monopoly.Presentation;

public static class Extensions
{
    public static IServiceCollection AddPresentationServices(this IServiceCollection services)
    {
        services.AddSignalR();
        return services;
    }

    public static IEndpointRouteBuilder UsePresentationEndpoints(this IEndpointRouteBuilder routeBuilder)
    {
        routeBuilder.MapHub<GameHub>("game-hub");
        return routeBuilder;
    }
}
