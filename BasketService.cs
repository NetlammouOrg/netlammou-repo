using Data.Data.Infrastructure;
using Domain.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ServicesPattern 
{
   public class BasketService : Service<basket>, IBasket
    {
        public static IDatabaseFactory dbFactory;
        public static IUnitOfWork myUnit;

        public BasketService() : base(myUnit)
        {
            dbFactory = new DatabaseFactory();
            myUnit = new UnitOfWork(dbFactory);
        }
        public List<basket> GetBasketProduct(int idVlt)
        {
            //List<basket> listBasket=new List<basket>();
          /* var listProdByID= myUnit.GetRepository<basket>().GetMany(br=>br.idVolenteer==idVlt);
            foreach (basket b in listProdByID)
            {
                listBasket.Add(b);
            }*/
           return myUnit.GetRepository<basket>().GetMany(br => br.idVolenteer == idVlt).ToList<basket>();
        }
       
    }
}
