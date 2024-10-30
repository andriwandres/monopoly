using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Monopoly.Presentation.Endpoints;
using Monopoly.Presentation.Hubs;

namespace Monopoly.Presentation;

public static class DependencyInjection
{
    public static IServiceCollection AddPresentationServices(this IServiceCollection services)
    {
        services.AddSignalR();
        services.AddCors();
        return services;
    }

    public static WebApplication UsePresentationMiddleware(this WebApplication application, IConfiguration configuration)
    {
        application.MapHub<GameHub>("game-hub");
        application.MapGameEndpoints();

        application.UseCors(builder =>
        {
            var cors = configuration.GetSection("Cors").Get<CorsConfiguration>()!;

            builder.WithMethods(cors.Methods);
            builder.WithHeaders(cors.Headers);
            builder.WithOrigins(cors.Origins);
            builder.AllowCredentials();
        });
        
        return application;
    }

    private record CorsConfiguration(
        string Methods, 
        string Headers, 
        string[] Origins
    );
}
