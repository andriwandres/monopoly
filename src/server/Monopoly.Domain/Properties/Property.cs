namespace Monopoly.Domain.Properties;

public sealed class Property
{
    public int PropertyId { get; set; }

    public string Name { get; set; } = null!;
    public PropertyType Type { get; set; }

    public string ImagePath { get; set; } = null!;
    
    public int Price { get; set; }
    public int MortgageValue { get; set; }
    public int HouseCost { get; set; }
    public int HotelCost { get; set; }
    public int BaseRent { get; set; }
    public int RentWithOnHouse { get; set; }
    public int RentWithTwoHouses { get; set; }
    public int RentWithThreeHouses { get; set; }
    public int RentWithFourHouses { get; set; }
    public int RentWithHotel { get; set; }
}