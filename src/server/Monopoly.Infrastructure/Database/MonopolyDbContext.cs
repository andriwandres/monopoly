using System.Reflection;
using Microsoft.EntityFrameworkCore;

namespace Monopoly.Infrastructure.Database;

internal sealed class MonopolyDbContext : DbContext
{
    public MonopolyDbContext(DbContextOptions<MonopolyDbContext> options) : base(options)
    {
    }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.ApplyConfigurationsFromAssembly(Assembly.GetExecutingAssembly());
    }
}
