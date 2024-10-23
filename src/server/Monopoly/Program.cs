using Monopoly.Infrastructure;

var builder = WebApplication.CreateBuilder(args);
var configuration = builder.Configuration;

builder.Services
    .AddInfrastructureServices(configuration);

var app = builder.Build();
app.Run();


