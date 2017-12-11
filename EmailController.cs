using Pidev.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Mail;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;
namespace Pidev.Controllers
{
    public class EmailController : Controller
    {
        // GET: Email
        public ActionResult Contact()
        {
            return View("Contact");
        }
        /*
        [HttpPost]
        public ActionResult Form(string recieverEmail, string subject, string message)
        {
            try
            {

                if (ModelState.IsValid)
                {
                    var senderemail = new MailAddress("imen.sahli1706@gmail.com", "test");
                    var recieveremail = new MailAddress(recieverEmail, "Reciever");
                    var password = "123allah*";
                    var sub = subject;
                    var body = message;
                    var smtp = new SmtpClient
                    {
                        Host = "smtp.gmail.com",
                        Port = 587,
                        EnableSsl = true,
                        DeliveryMethod = SmtpDeliveryMethod.Network,
                        UseDefaultCredentials = false,
                        Credentials = new NetworkCredential(senderemail.Address, password)

                    };
                    using (var mess = new MailMessage(senderemail, recieveremail)
                    {
                        Subject = subject,
                        Body = body

                    }

                        )
                    {
                        smtp.Send(mess);
                    }
                    return View();
                }
            }
            catch (Exception)
            {
                ViewBag.Error = "there is an error";
            }

            return View();
        }*/

        
       //Mailing
       [HttpPost]
       [ValidateAntiForgeryToken]
       public async Task<ActionResult> Contact(EmailFormModel model)
       {
           if (ModelState.IsValid)
           {
               var body = "<p>Email From: {0} ({1})</p><p>Message:</p><p>{2}</p>";
               var message = new MailMessage();
               message.To.Add(new MailAddress("recipient@gmail.com"));  // replace with valid value 
               message.From = new MailAddress("sender@outlook.com");  // replace with valid value
               message.Subject = "Your email subject";
               message.Body = string.Format(body, model.FromName, model.FromEmail, model.Message);
               message.IsBodyHtml = true;

               using (var smtp = new SmtpClient())
               {
                   var credential = new NetworkCredential
                   {
                       UserName = "user@outlook.com",  // replace with valid value
                       Password = "password"  // replace with valid value
                   };
                   smtp.Credentials = credential;
                   smtp.Host = "smtp-mail.outlook.com";
                   smtp.Port = 587;
                   smtp.EnableSsl = true;
                   await smtp.SendMailAsync(message);
                   return RedirectToAction("Sent");
               }
           }
           return View(model);
       }

       public ActionResult Sent()
       {
           return View();
       }
    }
}