package it.polimi.ingsw.Model;

import java.util.ArrayList;

public class Production {
    private ArrayList<CostOfCard> ProductionCost = new ArrayList<>();
    private ArrayList<CostOfCard> ProductionProfit = new ArrayList<>();

    public Production(ArrayList<CostOfCard> productionCost, ArrayList<CostOfCard> productionProfit) {
        ProductionCost = productionCost;
        ProductionProfit = productionProfit;
    }

    public ArrayList<CostOfCard> getProductionCost() {
        return ProductionCost;
    }

    public ArrayList<CostOfCard> getProductionProfit() {
        return ProductionProfit;
    }

    public boolean selectedResourcesCheck(ArrayList<CostOfCard>  strongBoxResources, ArrayList<CostOfCard> resourcesFromWarehouse){ // Funzione che controlla se la somma delle risorse selezionate i dallo strongbox e dal warehouse sono maggiori di quelle richieste nel primo array passato


        for(CostOfCard costOfCard : ProductionCost){
            int costNumber = costOfCard.getCostNumber();
            int ResouceNumber = 0;
            int StrongboxNumber = 0;

            // CostOfCard one = strongBoxResources.stream().filter(a->a.getCostColor().equals(costOfCard.getCostColor())).collect(Collectors.toList()).get(0);
            for (CostOfCard costOfCard1 : strongBoxResources){
                if (costOfCard.getCostColor() == costOfCard1.getCostColor()){
                    StrongboxNumber = costOfCard1.getCostNumber();
                }
            }
            for (CostOfCard costOfCard2 : resourcesFromWarehouse){
                if (costOfCard.getCostColor() == costOfCard2.getCostColor()){
                    ResouceNumber = costOfCard2.getCostNumber();
                }
            }
            if (costNumber > ResouceNumber + StrongboxNumber){
                return false;
            }

        }
        return true;
    }
    public boolean Produce(Player player, ArrayList<CostOfCard> resoucesFromStrongbox, ArrayList<CostOfCard> resourcesFromWarehouse) {
        // Le resources from Warehouse e from Strongbox me le deve passare il Player
        if (!(selectedResourcesCheck(resoucesFromStrongbox, resourcesFromWarehouse))){
            return false;
        }
        if (!(player.CheckResources(resoucesFromStrongbox, resourcesFromWarehouse))){
            return false;
        }
        for (CostOfCard costOfCard : resoucesFromStrongbox){
            player.getStrongbox().RemoveResourcesFromStrongbox(costOfCard.getCostNumber(), costOfCard.getCostColor());
        }
        return true;
    }





}
