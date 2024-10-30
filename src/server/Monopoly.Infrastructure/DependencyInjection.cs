using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Monopoly.Application.Games;
using Monopoly.Application.Players;
using Monopoly.Domain.Common;
using Monopoly.Infrastructure.Common;
using Monopoly.Infrastructure.Database;
using Monopoly.Infrastructure.Repositories;

namespace Monopoly.Infrastructure;

public static class DependencyInjection
{
    public static IServiceCollection AddInfrastructureServices(this IServiceCollection services, IConfiguration configuration)
    {
        return services
            .AddDatabase(configuration)
            .AddRepositories()
            .AddCommonServices();
    }

    private static IServiceCollection AddDatabase(this IServiceCollection services, IConfiguration configuration)
    {
        string? connectionString = configuration.GetConnectionString("Database");
        string migrationAssemblyName = typeof(DependencyInjection).Assembly.FullName!;

        services.AddDbContext<MonopolyDbContext>(builder =>
        {
            builder.UseNpgsql(connectionString, options =>
            {
                options.MigrationsAssembly(migrationAssemblyName);
            });
        });

        return services;
    }

    private static IServiceCollection AddRepositories(this IServiceCollection services)
    {
        return services
            .AddTransient<IGameRepository, GameRepository>()
            .AddTransient<IPlayerRepository, PlayerRepository>();
    }

    private static IServiceCollection AddCommonServices(this IServiceCollection services)
    {
        return services.AddTransient<IDateProvider, DateProvider>();
    }
}
