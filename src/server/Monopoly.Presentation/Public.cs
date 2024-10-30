using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Routing;
using Microsoft.Extensions.DependencyInjection;
using Monopoly.Presentation.Endpoints;
using Monopoly.Presentation.Hubs;

namespace Monopoly.Presentation;

public static class Public
{
    public static IServiceCollection AddPresentationServices(this IServiceCollection services)
    {
        services.AddSignalR();
        services.AddCors();
        return services;
    }

    public static WebApplication UsePresentationEndpoints(this WebApplication application)
    {
        application.MapHub<GameHub>("game-hub");
        application.MapGameEndpoints();

        application.UseCors(configure =>
        {
            configure.AllowAnyMethod();
            configure.AllowAnyHeader();
            configure.AllowCredentials();
            configure.WithOrigins("http://localhost:4200");
        });
        
        return application;
    }
}
