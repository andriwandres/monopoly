using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using Monopoly.Domain.Properties;

namespace Monopoly.Infrastructure.Configurations;

public sealed class PropertyGameConfiguration : IEntityTypeConfiguration<PropertyGame>
{
    public void Configure(EntityTypeBuilder<PropertyGame> builder)
    {
        // Keys
        builder.HasKey(propertyGame => propertyGame.PropertyGameId);

        // Indexes
        builder.HasIndex(propertyGame => new { propertyGame.PropertyId, propertyGame.GameId })
            .IsUnique();
        
        // Properties
        builder.Property(propertyGame => propertyGame.NumberOfHousesBuilt)
            .HasDefaultValue(0)
            .IsRequired();
        
        builder.Property(propertyGame => propertyGame.IsMortgaged)
            .HasDefaultValue(false)
            .IsRequired();
        
        // Relationships
        builder.HasOne(propertyGame => propertyGame.Property)
            .WithMany(property => property.PropertyGames)
            .HasForeignKey(propertyGame => propertyGame.PropertyId)
            .IsRequired();

        builder.HasOne(propertyGame => propertyGame.Game)
            .WithMany(game => game.Properties)
            .HasForeignKey(propertyGame => propertyGame.GameId)
            .IsRequired();

        builder.HasOne(propertyGame => propertyGame.Owner)
            .WithMany(player => player.OwnedProperties)
            .HasForeignKey(propertyGame => propertyGame.OwnerPlayerId);
    }
}