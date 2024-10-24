namespace Monopoly.Presentation.Events.Dice;

public sealed record DiceThrownEvent(string PlayerNickname, int Die1, int Die2);
