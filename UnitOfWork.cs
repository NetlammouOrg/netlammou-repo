using Data.Repositories;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static Data.Repositories.EventRepo;

namespace Data.Infrastructure
{
    public class UnitOfWork : IUnitOfWork
    {

        private MyContext dataContext;

        IDatabaseFactory dbFactory;
        public UnitOfWork(IDatabaseFactory dbFactory)
        {
            this.dbFactory = dbFactory;
            dataContext = dbFactory.DataContext;
        }

        public void Commit()
        {
            dataContext.SaveChanges();
        }
        public void Dispose()
        {
            dataContext.Dispose();
        }
        public IRepository<T> GetRepository<T>() where T : class
        {
            IRepository<T> repo = new RepositoryBase<T>(dbFactory);
            return repo;
        }

        private IEventsRepositories eventRepository;
        public EventRepo.IEventsRepositories EventRepository
        {
            get
            {
                return eventRepository = new EventRepo(dbFactory);
            }
        }

        IEventsRepositories IUnitOfWork.EventRepository
        {
            get
            {
                return eventRepository = new EventRepo(dbFactory);
            }

            set
            {
                throw new NotImplementedException();
            }
        }
    }

}
