using Monopoly.Domain.Common;

namespace Monopoly.Infrastructure.Common;

public sealed class DateProvider : IDateProvider
{
    public DateTime Now() => DateTime.UtcNow;
}