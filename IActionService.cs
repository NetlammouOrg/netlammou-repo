using Domain.Entity;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Services
{
    public interface IActionService
    {
        void DeleteEvent(action evn);
        action SearchEventById(int EventId);
        
        void SaveChange();
    }
}
