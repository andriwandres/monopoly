using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using Monopoly.Domain.Properties;

namespace Monopoly.Infrastructure.Configurations;

public sealed class PropertyConfiguration : IEntityTypeConfiguration<Property>
{
    public void Configure(EntityTypeBuilder<Property> builder)
    {
        // Keys
        builder.HasKey(property => property.PropertyId);

        // Properties
        builder.Property(property => property.Name)
            .IsRequired();
        
        builder.Property(property => property.Type)
            .IsRequired();
        
        builder.Property(property => property.ImagePath)
            .IsRequired();
        
        builder.Property(property => property.Price)
            .IsRequired();
        
        builder.Property(property => property.MortgageValue)
            .IsRequired();
        
        builder.Property(property => property.HouseCost)
            .IsRequired();
        
        builder.Property(property => property.HotelCost)
            .IsRequired();
        
        builder.Property(property => property.BaseRent)
            .IsRequired();
        
        builder.Property(property => property.RentWithOneHouse)
            .IsRequired();
        
        builder.Property(property => property.RentWithTwoHouses)
            .IsRequired();
        
        builder.Property(property => property.RentWithThreeHouses)
            .IsRequired();
        
        builder.Property(property => property.RentWithFourHouses)
            .IsRequired();
        
        builder.Property(property => property.RentWithHotel)
            .IsRequired();
        
        // Relationships
        builder.HasMany(property => property.PropertyGames)
            .WithOne(propertyGame => propertyGame.Property);
    }
}
