using Monopoly.Infrastructure;
using Monopoly.Presentation;

var builder = WebApplication.CreateBuilder(args);
var configuration = builder.Configuration;

builder.Services
    .AddInfrastructureServices(configuration)
    .AddPresentationServices();

var app = builder.Build();

app.UsePresentationEndpoints();

app.Run();


