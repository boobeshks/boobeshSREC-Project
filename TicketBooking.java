public class TicketBooking {
    static int total=120;
    public static void main(String args[])
    {
        
        for(int i=0;i<5;i++)
        {
         BookTicket book=new BookTicket();
         CancelTicket cancel=new CancelTicket();
         book.start();
         cancel.start();
        }
        
    }

    
    public static synchronized void Book()
    {
        if(total==0)
        {
            System.out.println("Tickets sold out");
        }
        else{
            total--;
            System.out.println("Ticket booked! Number of available tickets is: "+total);
        }
        
    }
    public static synchronized void Cancel()
    {
        if(total==120)
        {
            System.out.println("There is no booking associated with the ticket cancellation request.");
        }
        else
        {
        total++;
        System.out.println("Ticket cancelled! Number of tickets available is: "+total);
        }
        
    }
    static class BookTicket extends Thread{
        
        public void run()
        {
            Book();
        }
    }
    static class CancelTicket extends Thread{
        
        public void run()
        {
           Cancel();
        }
    }
}
