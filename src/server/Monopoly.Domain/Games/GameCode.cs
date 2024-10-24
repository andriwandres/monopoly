namespace Monopoly.Domain.Games;

public static class GameCode
{
    private const int Length = 10;
    private const string PossibleCharacters = "abcdefghijklmnopqrstuvwxyz0123456789";
    
    public static string Create(Random random)
    {
        char[] characters = Enumerable
            .Repeat(string.Empty, Length)
            .Select(_ => PossibleCharacters[random.Next(PossibleCharacters.Length)])
            .ToArray();

        return new string(characters);
    }
}