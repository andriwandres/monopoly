using System.Reflection;
using Microsoft.EntityFrameworkCore;
using Monopoly.Domain.Games;
using Monopoly.Domain.Players;
using Monopoly.Domain.Properties;
using Monopoly.Domain.Transactions;

namespace Monopoly.Infrastructure.Database;

internal sealed class MonopolyDbContext : DbContext
{
    public DbSet<Game> Games { get; set; } = null!;
    public DbSet<Player> Players { get; set; } = null!;
    public DbSet<Property> Properties { get; set; } = null!;
    public DbSet<PropertyGame> PropertyGames { get; set; } = null!;
    public DbSet<Transaction> Transactions { get; set; } = null!;
    
    public MonopolyDbContext(DbContextOptions<MonopolyDbContext> options) : base(options)
    {
    }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.ApplyConfigurationsFromAssembly(Assembly.GetExecutingAssembly());
    }
}
