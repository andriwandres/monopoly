using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using Monopoly.Domain.Games;

namespace Monopoly.Infrastructure.Configurations;

public sealed class GameConfiguration : IEntityTypeConfiguration<Game>
{
    public void Configure(EntityTypeBuilder<Game> builder)
    {
        // Keys
        builder.HasKey(game => game.GameId);
        
        // Indexes
        builder.HasIndex(game => game.Code)
            .IsUnique();
        
        // Properties
        builder.Property(game => game.Code)
            .IsRequired();
        
        builder.Property(game => game.Status)
            .IsRequired();

        builder.Property(game => game.CreatedAt)
            .IsRequired();
        
        // Relationships
        builder.HasOne(game => game.CurrentTurnPlayer)
            .WithOne()
            .HasForeignKey<Game>(game => game.CurrentTurnPlayerId);

        builder.HasMany(game => game.Players)
            .WithOne(player => player.Game);

        builder.HasMany(game => game.Properties)
            .WithOne(propertyGame => propertyGame.Game);

        builder.HasMany(game => game.Transactions)
            .WithOne(transaction => transaction.Game);
    }
}