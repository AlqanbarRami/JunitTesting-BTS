import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
public class PlayersTest {
    Players players = new Players();


    @Test
    void CheckingPlayersName() {
        players.settingPlayersName("Rami","Alqanbar");
        assertEquals("Rami",players.getFirstPlayerName());
        assertEquals("Alqanbar",players.getSecondPlayerName());
    }

    //Avoid Tie
    @Test
    void chooseWhoStartsFirst() throws InterruptedException {
        for (int i = 0; i <= 100000; i++) {
            players.settingPlayersName("Rami", "Alqanbar");
            players.chooseWhoStartsFirst();
            assertNotEquals(players.getTwoDiceFirstPlayer(), players.getTwoDiceSecondPlayer());
        }
    }

    @Test
    void MaxNumberOfDiceIsTwelve() throws InterruptedException {
    for(int i = 0; i<=10000000; i++){
        players.chooseWhoStartsFirst();
        assertTrue(players.getTwoDiceFirstPlayer() <= 12);
        assertTrue(players.getTwoDiceSecondPlayer() <= 12);
    }
    }

    @Test
    void TheWinnerWillStart() throws InterruptedException {
        players.settingPlayersName("Rami","Alqanbar");
        assertEquals("Rami", players.shootersChoice(1));
        assertEquals("Alqanbar", players.shootersChoice(2));
    }

    @Test
    void ArraySizeAndEmpty(){
        players.settingAllPositionToZero();
        int zoneLength =  players.getBattleZone().length;
        // Length should be 10
        assertEquals(10,zoneLength);
        // Let's check the row and should be 10
        for(int i=0; i<=9;i++){
            assertEquals(zoneLength,players.battleZone[i].length);
        }
        //Now let's Check that array will bet always empty at the beginning
        for(int i=0; i<=9; i++){
            for(int j=0; j<=9;j++){
                //Check all places
                assertEquals(0,players.battleZone[i][j]);
            }
        }
    }

    //Checking that there are ships in the first and second players zone.
    @Test
    void CheckDistributionGeneral(){
        players.settingPlayersName("Rami","Alqanbar");
        players.distributionOfShipsInTheOceanFirstPlayer();
        players.distributionOfShipsInTheOceanSecondPlayer();
        int totalPlacesFirstPlayer = 0;
        int totalPlacesSecondPlayer = 0;
        for(int i=0; i<=9;i++){
            for(int j=0; j<=9;j++){
                if(players.firstPlayerShips[i][j] != 0){
                    totalPlacesFirstPlayer++;
                }
                if(players.secondPlayerShips[i][j] != 0){
                    totalPlacesSecondPlayer++;
                }
            }
        }
        assertEquals(30,totalPlacesFirstPlayer);  // should be total 30 places in th array that are not 0;
        assertEquals(30,totalPlacesSecondPlayer);
    }

    @Test
    void CheckDistributionFirstPlayer(){
        players.settingPlayersName("Rami","Alqanbar");
        players.distributionOfShipsInTheOceanFirstPlayer();
        int totalPlacesFirstPlayer = 0;
        for(int i=0; i<=9;i++){
            for(int j=0; j<=9;j++){
                if(players.firstPlayerShips[i][j] != 0){
                    totalPlacesFirstPlayer++;
                }
            }
        }
        assertEquals(30,totalPlacesFirstPlayer);  // should be total 30 places in th array that are not 0;
    }
    @Test
    void CheckDistributionSecondPlayer(){
        players.settingPlayersName("Rami","Alqanbar");
        players.distributionOfShipsInTheOceanSecondPlayer();
        int totalPlacesSecondPlayer = 0;
        for(int i=0; i<=9;i++){
            for(int j=0; j<=9;j++){
                if(players.secondPlayerShips[i][j] != 0){
                    totalPlacesSecondPlayer++;
                }
            }
        }
        assertEquals(30,totalPlacesSecondPlayer);  // should be total 30 places in th array that are not 0;
    }

    @Test
    void CheckHealthAfterDistributionAndAtBeginning() throws InterruptedException {
        players.settingPlayersName("Rami", "Alqanbar");
        players.distributionOfShipsInTheOceanFirstPlayer();
        players.distributionOfShipsInTheOceanSecondPlayer();
        players.chooseWhoStartsFirst();
        assertEquals(100,players.getFirstPlayerHealth());
        assertEquals(100,players.getSecondPlayerHealth());
    }

   @Test
    void CheckShooterChoose() throws InterruptedException {
       players.settingPlayersName("Rami", "Alqanbar");
       assertEquals(players.getFirstPlayerName(),players.shootersChoice(1));
   }


        @Test
        void TheMaxNumberOfRandomPositionIsNine(){
            for(int i = 0; i< 100; i++) {
                int number = players.getRandomPosition();
                assert (number <= 9);
            }
        }
        @Test
        void CheckTotalAircraftCarrier(){
            players.settingPlayersName("Rami","Alqanbar");
            players.distributionOfShipsInTheOceanFirstPlayer();
            players.distributionOfShipsInTheOceanSecondPlayer();
            int totalAirCraftCarrierFirsPlayer=0;
            int totalAirCraftCarrierSecondPlayer=0;
            for(int i=0; i<=9;i++){
                for(int j=0; j<=9;j++){
                    if(players.firstPlayerShips[i][j] == 5){
                        totalAirCraftCarrierFirsPlayer++;
                    }
                    if(players.secondPlayerShips[i][j] ==5){
                        totalAirCraftCarrierSecondPlayer++;
                    }
                }
            }
            // Enligt krav 5*1 och det betyder 5 för varje spelare, 5+5= 10
            assertEquals(10,totalAirCraftCarrierFirsPlayer + totalAirCraftCarrierSecondPlayer );
        }

        @Test
        void CheckTotalBattleShip(){
                players.settingPlayersName("Rami","Alqanbar");
                players.distributionOfShipsInTheOceanFirstPlayer();
                players.distributionOfShipsInTheOceanSecondPlayer();
                int totaBattleShipFirstPlayer=0;
                int totalBattleShipSecondPlayer=0;
                for(int i=0; i<=9;i++){
                    for(int j=0; j<=9;j++){
                        if(players.firstPlayerShips[i][j] == 4){
                            totaBattleShipFirstPlayer++;
                        }
                        if(players.secondPlayerShips[i][j] == 4){
                            totalBattleShipSecondPlayer++;
                        }
                    }
                }
                // Enligt krav (4*1) * 2 och det betyder 8 för varje spelare, 8+8= 16
                assertEquals(16,totaBattleShipFirstPlayer + totalBattleShipSecondPlayer );
        }

        @Test
        void CheckTotalCruiser(){
            players.settingPlayersName("Rami","Alqanbar");
            players.distributionOfShipsInTheOceanFirstPlayer();
            players.distributionOfShipsInTheOceanSecondPlayer();
            int totalCruiserFirstPlayer=0;
            int totalCruiserSecondPlayer=0;
            for(int i=0; i<=9;i++){
                for(int j=0; j<=9;j++){
                    if(players.firstPlayerShips[i][j] == 3){
                        totalCruiserFirstPlayer++;
                    }
                    if(players.secondPlayerShips[i][j] == 3){
                        totalCruiserSecondPlayer++;
                    }
                }
            }
            // Enligt krav (3*1) * 3 och det betyder 9 för varje spelare, 9+9= 16
            assertEquals(18,totalCruiserFirstPlayer + totalCruiserSecondPlayer );
        }

        @Test
        void CheckTotalSubmarines(){
            players.settingPlayersName("Rami","Alqanbar");
            players.distributionOfShipsInTheOceanFirstPlayer();
            players.distributionOfShipsInTheOceanSecondPlayer();
            int totalSubmarinesFirstPlayer=0;
            int totalSubmarinesSecondPlayer=0;
            for(int i=0; i<=9;i++){
                for(int j=0; j<=9;j++){
                    if(players.firstPlayerShips[i][j] == 2){
                        totalSubmarinesFirstPlayer++;
                    }
                    if(players.secondPlayerShips[i][j] == 2){
                        totalSubmarinesSecondPlayer++;
                    }
                }
            }
            // Enligt krav (2*1) * 4 och det betyder 8 för varje spelare, 8+8= 16
            assertEquals(16,totalSubmarinesFirstPlayer + totalSubmarinesSecondPlayer );
        }

        //When any part of the ships is targeted, the number will change to one.
        // In this test, we are trying to make sure that the number actually changes.
        //Check that the health of the second player is affected by targeting troops
        // Check that the health of the first player is affected by targeting troops
        @Test
        void CheckingTheReplaceToFirst() throws InterruptedException {
                players.settingPlayersName("Rami", "alqanbar");
                players.distributionOfShipsInTheOceanFirstPlayer();
                players.distributionOfShipsInTheOceanSecondPlayer();
                players.setFirstPlayerHealth(100);
                players.setSecondPlayerHealth(100);
                players.settingHittingHistoryToSymbol();
            //We are trying to make successful targeting here
            while ((players.getSecondPlayerHealth() != 0) || (players.getFirstPlayerHealth() != 0)) {
                players.shootFromFirstToSecond();
                players.shootFromSecondToFirst();
            }
            for(int i = 0; i<=9;i++){
                for(int j=0; j<=9; j++){
                    if(players.secondPlayerShips[i][j] == 1 && players.firstPlayerShips[i][j] == 1){
                        assertNotEquals(100,players.getFirstPlayerHealth());
                        assertNotEquals(100,players.getSecondPlayerHealth());
                        assertEquals(1,players.secondPlayerShips[i][j]);
                        assertEquals(1,players.firstPlayerShips[i][j]);
                    }
                }
            }
        }







    }
