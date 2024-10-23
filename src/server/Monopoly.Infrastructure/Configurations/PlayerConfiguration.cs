using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using Monopoly.Domain.Players;

namespace Monopoly.Infrastructure.Configurations;

public sealed class PlayerConfiguration : IEntityTypeConfiguration<Player>
{
    public void Configure(EntityTypeBuilder<Player> builder)
    {
        // Keys
        builder.HasKey(player => player.PlayerId);

        // Indexes
        builder.HasIndex(player => new { player.GameId, player.Nickname })
            .IsUnique();
        
        // Properties
        builder.Property(player => player.Nickname)
            .IsRequired();

        builder.Property(player => player.ColorHex)
            .IsRequired();
        
        builder.Property(player => player.Money)
            .HasDefaultValue(Player.StartingMoney)
            .IsRequired();
        
        builder.Property(player => player.Position)
            .HasDefaultValue(Player.StartingPosition)
            .IsRequired();
        
        builder.Property(player => player.IsInJail)
            .HasDefaultValue(false)
            .IsRequired();
        
        builder.Property(player => player.NumberOfTurnsInJail)
            .HasDefaultValue(0)
            .IsRequired();
        
        builder.Property(player => player.TurnOrder)
            .IsRequired();
        
        builder.Property(player => player.CreatedAt)
            .IsRequired();

        // Relationships
        builder.HasOne(player => player.Game)
            .WithMany(game => game.Players)
            .HasForeignKey(player => player.GameId)
            .IsRequired();

        builder.HasMany(player => player.OwnedProperties)
            .WithOne(propertyGame => propertyGame.Owner);
        
        builder.HasMany(player => player.InitiatedTransactions)
            .WithOne(propertyGame => propertyGame.FromPlayer);
        
        builder.HasMany(player => player.ReceivedTransactions)
            .WithOne(propertyGame => propertyGame.ToPlayer);
    }
}
