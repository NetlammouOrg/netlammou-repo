using Domain.Entity;
using ServicesPattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ServicesPattern
{
    public interface IBasket : IService<basket>
    {
         List<basket> GetBasketProduct(int idVlt);
       
    }
}
