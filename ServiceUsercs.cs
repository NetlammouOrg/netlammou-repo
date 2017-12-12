using Data.Infrastructure;
using Domain.Entity;
using Service.Pattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Service
{
    public class ServiceUsercs:Service<user>,IUserService
    {
        private static DatabaseFactory dbf = new DatabaseFactory();
        private static UnitOfWork uwk = new UnitOfWork(dbf);
        public ServiceUsercs(): base(uwk)
        {
        }

    }
}
