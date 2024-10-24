using FluentAssertions;
using Monopoly.Domain.Die;
using Xunit;

namespace Monopoly.Domain.Tests;

public sealed class DiceTest
{
    [Fact]
    public void Throw_ShouldReturnRandomDieFaces()
    {
        var random = new Random(Seed: 420);

        Dice.Throw(random).Should().Be((1, 1));
        Dice.Throw(random).Should().Be((3, 2));
        Dice.Throw(random).Should().Be((5, 4));
    }
}
