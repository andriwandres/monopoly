using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Monopoly.Infrastructure.Database;

namespace Monopoly.Infrastructure;

public static class DependencyInjection
{
    public static IServiceCollection AddInfrastructureServices(this IServiceCollection services, IConfiguration configuration)
    {
        return services
            .AddDatabase(configuration);
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
}
