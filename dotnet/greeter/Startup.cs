using Greeter.Config;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Steeltoe.Management.Endpoint.Health;

namespace Greeter
{
    public class Startup
    {
        private readonly IConfiguration _configuration;

        public Startup(IConfiguration configuration)
        {
            _configuration = configuration;
            
        }

        // register services into container
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddOptions();
            services.Configure<BillboardConfig>(_configuration);
            services.AddHealthActuator(_configuration);
            services.AddMvc();
        }

        // activate services & setup middleware
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            app.UseHealthActuator();
            app.UseStaticFiles();
            app.UseMvc();
            
        }
    }
}
