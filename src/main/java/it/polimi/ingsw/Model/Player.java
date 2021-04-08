package it.polimi.ingsw.Model;


public class Player {
    private final String nickname;
    private FaithTrack faithTrack;
    private Warehouse warehouse;
    private Strongbox strongbox;
    private LeaderCard[] leaderCards;
    private Slots slots;


    public Player(String nickname, LeaderCard[] FourLeaderCards) {

        this.nickname = nickname;
        this.faithTrack = new FaithTrack();
        this.warehouse = new Warehouse();
        this.strongbox = new Strongbox();
        this.leaderCards = FourLeaderCards;
        this.slots = new Slots();
    }

    public String getNickname() {
        return nickname;
    }

    public FaithTrack getFaithTrack() {
        return faithTrack;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Strongbox getStrongbox() {
        return strongbox;
    }

    public LeaderCard[] getLeaderCards() {
        return leaderCards;
    }

    public Slots getSlots() {
        return slots;
    }

}
 /*   public void marketTray(MarketTray marketTray ){
        //ChiamaLaFunzioneDiMarketTray
    }
    public void produceByCard(DevelopmentCard developmentCard){
        //chiama la funzione di developmentCard
    }
    public void produceTwoOne(Resource First,Resource Second ){
        //Prende 2 risorse e ne mette una
    }
    public void ActiveLeaderCard(LeaderCard leaderCard){
        //Chiama la Funzione Di Leader Card
    }

    public void DiscardLeaderCard(LeaderCard leaderCard){
        //Chiama La Funzione Di LeaderCard
    }

    public void chooseLeaderCard(LeaderCard[] leaderCard){
        // da rivedere
    }
    public void BuyDevelopmentCard(int Colonna, int Righe){
        //Chiama la funzione di DevelopmentCard
        //Chiama la funzione di Slots
    }

  */



//da rivedere









