using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static Data.Repositories.EventRepo;

namespace Data.Infrastructure
{
    public interface IUnitOfWork : IDisposable
    {
        IEventsRepositories EventRepository { get; set; }

        IRepository<T> GetRepository<T>() where T : class;
        void Commit();

    }
}
