FROM mcr.microsoft.com/dotnet/aspnet:8.0 AS base
WORKDIR /app
EXPOSE 5000
EXPOSE 5001

FROM mcr.microsoft.com/dotnet/sdk:8.0 AS build
WORKDIR /src

COPY ["Monopoly/Monopoly.csproj", "Monopoly/"]
RUN dotnet restore "Monopoly/Monopoly.csproj"
COPY . .
WORKDIR "/src/Monopoly"
RUN dotnet build "Monopoly.csproj" -c Release -o /app/build

FROM build AS publish
RUN dotnet publish "Monopoly.csproj" -c Release -o /app/publish /p:UseAppHost=false

FROM base AS final
WORKDIR /app
COPY --from=publish /app/publish .
ENTRYPOINT ["dotnet", "Monopoly.dll"]
