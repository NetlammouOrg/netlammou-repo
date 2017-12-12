using Data.Data.Infrastructure;
using Domain.Entity;
using ServicePattern;
using ServicesPattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace ServicePattern
{
   public class Products : Service<product>, IProduct
    {
        public static IDatabaseFactory dbFactory;
        public static IUnitOfWork myUnit;

        public Products() : base(myUnit)
        {
            dbFactory = new DatabaseFactory();
            myUnit = new UnitOfWork(dbFactory);
        }

        public void CreateProduct(product p)
        {
            myUnit.GetRepository<product>().Add(p);
            myUnit.Commit();
        }

       

        public void DeleteProduct(product p)
        {
            myUnit.GetRepository<product>().Delete(p);
            myUnit.Commit();
        }

       
        public List<product> GetAllProducts()
        {
            return myUnit.GetRepository<product>().GetAll().ToList();
        }

        public product GetProdByID(int productID)
        {
            return myUnit.GetRepository<product>().GetById(productID);
        }

      

        public void UpdateProduct(product p)
        {
            myUnit.GetRepository<product>().Update(p);
            myUnit.Commit();
        }

       
    }
}

