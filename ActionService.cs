using Data.Infrastructure;
using Domain.Entity;
using Pattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services 
{
    public class ActionService : Service<action>, IActionService
    {

        private static IDatabaseFactory dbf = new DatabaseFactory();
        private static IUnitOfWork ut = new UnitOfWork(dbf);

        public ActionService() : base(ut)
        { }

        public void RemoveEvent(int id)
        {
            var o = ut.GetRepository<action>().GetById(id);
            dbf.DataContext.actions.Remove(o);
            ut.Commit();
        }

        public action SearchEventById(int EventId)
        {
            return ut.EventRepository.GetById(EventId);
        }
        public void DeleteEvent(action evn)
        {

            ut.EventRepository.Delete(evn);
        }
        public void SaveChange()
        {
            // System.Diagnostics.Debug.WriteLine("SSSSSSSSSSSSSSSav");

            ut.Commit();
        }
    }
}
