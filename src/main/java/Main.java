public class Main {
    public static void main(String[] args) throws InterruptedException {
        // write your code here
        Players players = new Players();
        players.settingPlayersName("Rami", "Alqanbar");
        players.distributionOfShipsInTheOceanFirstPlayer();
        players.distributionOfShipsInTheOceanSecondPlayer();
        players.settingHittingHistoryToSymbol();
        players.setFirstPlayerHealth(100);
        players.setSecondPlayerHealth(100);
        while (players.getFirstPlayerHealth() != 0 || players.getSecondPlayerHealth() != 0){
            players.shootFromFirstToSecond();
            players.shootFromSecondToFirst();
        }

    }

}
