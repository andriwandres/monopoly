using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;
using Monopoly.Domain.Transactions;

namespace Monopoly.Infrastructure.Configurations;

public sealed class TransactionConfiguration : IEntityTypeConfiguration<Transaction>
{
    public void Configure(EntityTypeBuilder<Transaction> builder)
    {
        // Keys
        builder.HasKey(transaction => transaction.TransactionId);

        // Properties
        builder.Property(transaction => transaction.Amount)
            .IsRequired();
        
        builder.Property(transaction => transaction.Type)
            .IsRequired();
        
        builder.Property(transaction => transaction.CreatedAt)
            .IsRequired();

        // Relationships
        builder.HasOne(transaction => transaction.Game)
            .WithMany(game => game.Transactions)
            .HasForeignKey(transaction => transaction.GameId);
        
        builder.HasOne(transaction => transaction.FromPlayer)
            .WithMany(player => player.InitiatedTransactions)
            .HasForeignKey(transaction => transaction.FromPlayerId);
        
        builder.HasOne(transaction => transaction.ToPlayer)
            .WithMany(player => player.ReceivedTransactions)
            .HasForeignKey(transaction => transaction.ToPlayerId);
    }
}
