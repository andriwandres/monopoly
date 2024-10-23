using System;
using Microsoft.EntityFrameworkCore.Migrations;
using Npgsql.EntityFrameworkCore.PostgreSQL.Metadata;

#nullable disable

namespace Monopoly.Infrastructure.Migrations
{
    /// <inheritdoc />
    public partial class Initial : Migration
    {
        /// <inheritdoc />
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.CreateTable(
                name: "Properties",
                columns: table => new
                {
                    PropertyId = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    Name = table.Column<string>(type: "text", nullable: false),
                    Type = table.Column<int>(type: "integer", nullable: false),
                    ImagePath = table.Column<string>(type: "text", nullable: false),
                    Price = table.Column<int>(type: "integer", nullable: false),
                    MortgageValue = table.Column<int>(type: "integer", nullable: false),
                    HouseCost = table.Column<int>(type: "integer", nullable: false),
                    HotelCost = table.Column<int>(type: "integer", nullable: false),
                    BaseRent = table.Column<int>(type: "integer", nullable: false),
                    RentWithOneHouse = table.Column<int>(type: "integer", nullable: false),
                    RentWithTwoHouses = table.Column<int>(type: "integer", nullable: false),
                    RentWithThreeHouses = table.Column<int>(type: "integer", nullable: false),
                    RentWithFourHouses = table.Column<int>(type: "integer", nullable: false),
                    RentWithHotel = table.Column<int>(type: "integer", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Properties", x => x.PropertyId);
                });

            migrationBuilder.CreateTable(
                name: "Games",
                columns: table => new
                {
                    GameId = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    CurrentTurnPlayerId = table.Column<int>(type: "integer", nullable: true),
                    Code = table.Column<string>(type: "text", nullable: false),
                    Status = table.Column<int>(type: "integer", nullable: false),
                    CreatedAt = table.Column<DateTime>(type: "timestamp with time zone", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Games", x => x.GameId);
                });

            migrationBuilder.CreateTable(
                name: "Players",
                columns: table => new
                {
                    PlayerId = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    GameId = table.Column<int>(type: "integer", nullable: false),
                    Nickname = table.Column<string>(type: "text", nullable: false),
                    ColorHex = table.Column<string>(type: "text", nullable: false),
                    Money = table.Column<int>(type: "integer", nullable: false, defaultValue: 1500),
                    Position = table.Column<int>(type: "integer", nullable: false, defaultValue: 1),
                    IsInJail = table.Column<bool>(type: "boolean", nullable: false, defaultValue: false),
                    NumberOfTurnsInJail = table.Column<int>(type: "integer", nullable: false, defaultValue: 0),
                    TurnOrder = table.Column<int>(type: "integer", nullable: false),
                    CreatedAt = table.Column<DateTime>(type: "timestamp with time zone", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Players", x => x.PlayerId);
                    table.ForeignKey(
                        name: "FK_Players_Games_GameId",
                        column: x => x.GameId,
                        principalTable: "Games",
                        principalColumn: "GameId",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "PropertyGames",
                columns: table => new
                {
                    PropertyGameId = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    PropertyId = table.Column<int>(type: "integer", nullable: false),
                    GameId = table.Column<int>(type: "integer", nullable: false),
                    OwnerPlayerId = table.Column<int>(type: "integer", nullable: false),
                    NumberOfHousesBuilt = table.Column<int>(type: "integer", nullable: false, defaultValue: 0),
                    IsMortgaged = table.Column<bool>(type: "boolean", nullable: false, defaultValue: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_PropertyGames", x => x.PropertyGameId);
                    table.ForeignKey(
                        name: "FK_PropertyGames_Games_GameId",
                        column: x => x.GameId,
                        principalTable: "Games",
                        principalColumn: "GameId",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_PropertyGames_Players_OwnerPlayerId",
                        column: x => x.OwnerPlayerId,
                        principalTable: "Players",
                        principalColumn: "PlayerId",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_PropertyGames_Properties_PropertyId",
                        column: x => x.PropertyId,
                        principalTable: "Properties",
                        principalColumn: "PropertyId",
                        onDelete: ReferentialAction.Cascade);
                });

            migrationBuilder.CreateTable(
                name: "Transactions",
                columns: table => new
                {
                    TransactionId = table.Column<int>(type: "integer", nullable: false)
                        .Annotation("Npgsql:ValueGenerationStrategy", NpgsqlValueGenerationStrategy.IdentityByDefaultColumn),
                    GameId = table.Column<int>(type: "integer", nullable: false),
                    FromPlayerId = table.Column<int>(type: "integer", nullable: true),
                    ToPlayerId = table.Column<int>(type: "integer", nullable: true),
                    Amount = table.Column<int>(type: "integer", nullable: false),
                    Type = table.Column<int>(type: "integer", nullable: false),
                    CreatedAt = table.Column<DateTime>(type: "timestamp with time zone", nullable: false)
                },
                constraints: table =>
                {
                    table.PrimaryKey("PK_Transactions", x => x.TransactionId);
                    table.ForeignKey(
                        name: "FK_Transactions_Games_GameId",
                        column: x => x.GameId,
                        principalTable: "Games",
                        principalColumn: "GameId",
                        onDelete: ReferentialAction.Cascade);
                    table.ForeignKey(
                        name: "FK_Transactions_Players_FromPlayerId",
                        column: x => x.FromPlayerId,
                        principalTable: "Players",
                        principalColumn: "PlayerId");
                    table.ForeignKey(
                        name: "FK_Transactions_Players_ToPlayerId",
                        column: x => x.ToPlayerId,
                        principalTable: "Players",
                        principalColumn: "PlayerId");
                });

            migrationBuilder.CreateIndex(
                name: "IX_Games_Code",
                table: "Games",
                column: "Code",
                unique: true);

            migrationBuilder.CreateIndex(
                name: "IX_Games_CurrentTurnPlayerId",
                table: "Games",
                column: "CurrentTurnPlayerId",
                unique: true);

            migrationBuilder.CreateIndex(
                name: "IX_Players_GameId_Nickname",
                table: "Players",
                columns: new[] { "GameId", "Nickname" },
                unique: true);

            migrationBuilder.CreateIndex(
                name: "IX_PropertyGames_GameId",
                table: "PropertyGames",
                column: "GameId");

            migrationBuilder.CreateIndex(
                name: "IX_PropertyGames_OwnerPlayerId",
                table: "PropertyGames",
                column: "OwnerPlayerId");

            migrationBuilder.CreateIndex(
                name: "IX_PropertyGames_PropertyId_GameId",
                table: "PropertyGames",
                columns: new[] { "PropertyId", "GameId" },
                unique: true);

            migrationBuilder.CreateIndex(
                name: "IX_Transactions_FromPlayerId",
                table: "Transactions",
                column: "FromPlayerId");

            migrationBuilder.CreateIndex(
                name: "IX_Transactions_GameId",
                table: "Transactions",
                column: "GameId");

            migrationBuilder.CreateIndex(
                name: "IX_Transactions_ToPlayerId",
                table: "Transactions",
                column: "ToPlayerId");

            migrationBuilder.AddForeignKey(
                name: "FK_Games_Players_CurrentTurnPlayerId",
                table: "Games",
                column: "CurrentTurnPlayerId",
                principalTable: "Players",
                principalColumn: "PlayerId");
        }

        /// <inheritdoc />
        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropForeignKey(
                name: "FK_Games_Players_CurrentTurnPlayerId",
                table: "Games");

            migrationBuilder.DropTable(
                name: "PropertyGames");

            migrationBuilder.DropTable(
                name: "Transactions");

            migrationBuilder.DropTable(
                name: "Properties");

            migrationBuilder.DropTable(
                name: "Players");

            migrationBuilder.DropTable(
                name: "Games");
        }
    }
}
