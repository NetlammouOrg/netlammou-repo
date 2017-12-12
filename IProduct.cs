using Domain.Entity;
using ServicesPattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Linq.Expressions;
using System.Text;
using System.Threading.Tasks;

namespace ServicePattern
{
    public interface IProduct : IService<product>
    {
        void CreateProduct(product p);
        List<product> GetAllProducts();
        void UpdateProduct(product p);
        product GetProdByID(int EventID);
        void DeleteProduct(product p);
    }
}


