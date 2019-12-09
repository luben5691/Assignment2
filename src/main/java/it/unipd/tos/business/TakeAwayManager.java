////////////////////////////////////////////////////////////////////
// Luca Benetazzo 1122109
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.TakeAwayBillException;
import it.unipd.tos.model.MenuItem;

public class TakeAwayManager implements TakeAwayBill {
    public double getOrderPrice(List<MenuItem> itemsOrdered) throws TakeAwayBillException {
        double totalFood = 0.0;
        double totalDrink = 0.0;
        int nrPanini = 0;
        double paninoLessExpensive = Double.MAX_VALUE;
        double commisione = 0.5;

        for (MenuItem menuItem : itemsOrdered) {
            if(menuItem.getType() == MenuItem.items.Bevanda) {
                totalDrink += menuItem.getPrice();
            }
            else {
                totalFood += menuItem.getPrice();
            }

            if(menuItem.getType() == MenuItem.items.Panino) {
                nrPanini++;
                if(paninoLessExpensive > menuItem.getPrice()) {
                    paninoLessExpensive = menuItem.getPrice();
                }
            }
        }

        if(itemsOrdered.size() > 30){
            throw new TakeAwayBillException("Hai superato il limite di 30 elementi");
        }

        if(nrPanini > 5){
            totalFood -= (paninoLessExpensive/2); 
        }

        if(totalFood > 50.0){
            totalFood -= (totalFood*0.1);
        }

        if(totalDrink + totalFood < 10.0) {
            return totalDrink + totalFood + commisione;    
        }else {
            return totalDrink + totalFood;
        }
        
    }
}