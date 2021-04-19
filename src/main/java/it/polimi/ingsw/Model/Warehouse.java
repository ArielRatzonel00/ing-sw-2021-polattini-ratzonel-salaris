package it.polimi.ingsw.Model;

import it.polimi.ingsw.Model.Marble.ColoredMarble;

import java.util.ArrayList;

public class Warehouse {
    private ColoredMarble.ColorMarble Colorrow1;
    private ColoredMarble.ColorMarble Colorrow2;
    private ColoredMarble.ColorMarble Colorrow3;
    private ColoredMarble.ColorMarble ColorrowExtra1;
    private ColoredMarble.ColorMarble ColorrowExtra2;
    private ColoredMarble row1;
    private ArrayList<ColoredMarble> row2;
    private ArrayList<ColoredMarble> row3;
    private ArrayList<ColoredMarble> rowextra1;
    private ArrayList<ColoredMarble> rowextra2;
    private boolean removeSuccess = true;

    private int[] TotalResourcesWarehouse = {0, 0, 0, 0}; //0=purple SERVANT, 1=blue SHIELD, 2=yellow COINS, 3=grey STONES

    public ColoredMarble getRow1() {
        return row1;
    }

    public ArrayList<ColoredMarble> getRow2() {
        return row2;
    }

    public ArrayList<ColoredMarble> getRow3() {
        return row3;
    }

    public ArrayList<ColoredMarble> getRowextra1() {
        return rowextra1;
    }

    public ArrayList<ColoredMarble> getRowextra2() {
        return rowextra2;
    }

    public boolean addToRow(ColoredMarble rowMarble, int row) {
        if (row == 1) {
            row1 = rowMarble;
            Colorrow1 = rowMarble.getColorMarble();
            return true;
        } else if (row == 2) {
            if (row2.size() == 0) {
                row2.add(rowMarble);
                Colorrow2 = rowMarble.getColorMarble();
                return true;
            } else if (row2.size() > 0 && row2.size() < 2 && rowMarble.getColorMarble().equals(Colorrow1)) {
                row2.add(rowMarble);
                return true;
            } else {
                return false;
            }
        } else if (row == 3) {
            if (row3.size() == 0) {
                row3.add(rowMarble);
                Colorrow3 = rowMarble.getColorMarble();
                return true;
            } else if (row3.size() > 0 && row3.size() < 3 && rowMarble.getColorMarble().equals(Colorrow2)) {
                row3.add(rowMarble);
                return true;
            } else {
                return false;
            }
        }
        return false; // manca la gestione di row = 4 e row = 5;
    }

    public boolean RemoveResourcesFromWare(int[] resources) { // il vettore che gli passo: 0=purple, 1=blue, 2=yellow, 3=grey
        //Il boolean che ritorno indietro serve per dirmi se la procedura è andata a buon fine

        switch (row1.getColorMarble()) {
            case PURPLE:
                if (resources[0] == 1) {
                    row1 = null;
                    resources[0] -= 1;
                }
                break;
            case BLUE:
                if (resources[1] == 1) {
                    row1 = null;
                    resources[1] -= 1;
                }
                break;
            case YELLOW:
                if (resources[2] == 1) {
                    row1 = null;
                    resources[2] -= 1;
                }
                break;
            case GREY:
                if (resources[3] == 1) {
                    row1 = null;
                    resources[3] -= 1;
                }
                break;
            default:
                break;
        }


        switch (Colorrow2) {
            case PURPLE:
                while (resources[0] > 0) {
                    row2.remove(row2.size() - 1);
                    resources[0] -= 1;
                }
                break;
            case BLUE:
                while (resources[1] > 0) {
                    row2.remove(row2.size() - 1);
                    resources[1] -= 1;
                }
                break;
            case YELLOW:
                while (resources[2] > 0) {
                    row2.remove(row2.size() - 1);
                    resources[2] -= 1;
                }
                break;
            case GREY:
                while (resources[3] > 0) {
                    row2.remove(row2.size() - 1);
                    resources[3] -= 1;
                }
                break;
            default:
                break;
        }

        switch (Colorrow3) {
            case PURPLE:
                while (resources[0] > 0) {
                    row3.remove(row3.size() - 1);
                    resources[0] -= 1;
                }
                break;
            case BLUE:
                while (resources[1] > 0) {
                    row3.remove(row3.size() - 1);
                    resources[1] -= 1;
                }
                break;
            case YELLOW:
                while (resources[2] > 0) {
                    row3.remove(row3.size() - 1);
                    resources[2] -= 1;
                }
                break;
            case GREY:
                while (resources[3] > 0) {
                    row3.remove(row3.size() - 1);
                    resources[3] -= 1;
                }
                break;
            default:
                break;
        }
        removeSuccess = true;

        for (int c = 0; c < 4; c++) {
            if (resources[c] != 0) {
                removeSuccess = false;
            }
        }

        return removeSuccess;
    }

    public boolean RemoveResourcesFromLead(int[] resources) { // il vettore che gli passo: 0=purple, 1=blue, 2=yellow, 3=grey
        //Il boolean che ritorno indietro serve per dirmi se la procedura è andata a buon fine

        switch (ColorrowExtra1) {
            case PURPLE:
                while (resources[0] > 0) {
                    rowextra1.remove(rowextra1.size() - 1);
                    resources[0] -= 1;
                }
                break;
            case BLUE:
                while (resources[1] > 0) {
                    rowextra1.remove(rowextra1.size() - 1);
                    resources[1] -= 1;
                }
                break;
            case YELLOW:
                while (resources[2] > 0) {
                    rowextra1.remove(rowextra1.size() - 1);
                    resources[2] -= 1;
                }
                break;
            case GREY:
                while (resources[3] > 0) {
                    rowextra1.remove(rowextra1.size() - 1);
                    resources[3] -= 1;
                }
                break;
            default:
                break;
        }

        switch (ColorrowExtra2) {
            case PURPLE:
                while (resources[0] > 0) {
                    rowextra2.remove(rowextra2.size() - 1);
                    resources[0] -= 1;
                }
                break;
            case BLUE:
                while (resources[1] > 0) {
                    rowextra2.remove(rowextra2.size() - 1);
                    resources[1] -= 1;
                }
                break;
            case YELLOW:
                while (resources[2] > 0) {
                    rowextra2.remove(rowextra2.size() - 1);
                    resources[2] -= 1;
                }
                break;
            case GREY:
                while (resources[3] > 0) {
                    rowextra2.remove(rowextra2.size() - 1);
                    resources[3] -= 1;
                }
                break;
            default:
                break;
        }


        removeSuccess = true;

        for (int c = 0; c < 4; c++) {
            if (resources[c] != 0) {
                removeSuccess = false;
            }
        }


        return removeSuccess;
    }





        /*
        ColoredMarble temp = null;
        if (row == 1) {
            temp = row1;
            row1 = null;
        } else if (row == 2) {
            temp = row2.get(row2.size() - 1);
            row2.remove(row2.size() - 1);
        } else if (row == 3) {

            temp = row3.get(row3.size() - 1);
            row3.remove(row3.size() - 1);
        }
        return temp;
         */

    public void moveResources(int r1, int r2) {
        int FromRow = 0;
        int toRow = 0;
        if (r1 > r2) {
            FromRow = r1;
            toRow = r2;
        } else {
            FromRow = r2;
            toRow = r1;
        }

        if (FromRow == 3 && toRow == 2) {
            if (row3.size() > row2.size()) {
                System.out.println("Can't do this move");
            } else {
                ArrayList<ColoredMarble> temp;
                ColoredMarble.ColorMarble tempColor = Colorrow2;
                temp = row2;
                row2 = row3;
                row3 = temp;
                Colorrow2 = Colorrow3;
                Colorrow3 = tempColor;
            }
        } else if (FromRow == 3 && toRow == 1) {
            if (row3.size() > 1) {
                System.out.println("Can't do this move");
            } else {
                ColoredMarble temp;
                temp = row1;
                row1 = row3.get(0);
                row3.remove(0);
                row3.add(temp);
            }
        } else if (FromRow == 2 && toRow == 1) {
            if (row2.size() > 1) {
                System.out.println("Can't do this move");
            } else {
                ColoredMarble temp;
                temp = row1;
                row1 = row2.get(0);
                row2.remove(0);
                row2.add(temp);
            }
        }


    }

    public int[] getTotalMaterials() {
        //mi assicuro che l'array sia azzerato
        TotalResourcesWarehouse[0] = 0;
        TotalResourcesWarehouse[1] = 0;
        TotalResourcesWarehouse[2] = 0;
        TotalResourcesWarehouse[3] = 0;

        //nell'array che ritorno indietro al posto 0=purple, 1=blue, 2=yellow, 3=grey

        //se row1 ha un colore vuol dire che contiene una risorsa di quel colore
        switch (row1.getColorMarble()) {
            case PURPLE:
                TotalResourcesWarehouse[0]++;
                break;
            case BLUE:
                TotalResourcesWarehouse[1]++;
                break;
            case YELLOW:
                TotalResourcesWarehouse[2]++;
                break;
            case GREY:
                TotalResourcesWarehouse[3]++;
                break;
        }

        //controllo quanti elementi ha row2 con un for (al massimo ho due elementi) e poi controllo il colore di tali elementi
        for (int c = 1; c < 3; c++) {
            if (row2.size() == c) {
                switch (Colorrow2) {
                    case PURPLE:
                        TotalResourcesWarehouse[0] += c;
                        break;
                    case BLUE:
                        TotalResourcesWarehouse[1] += c;
                        break;
                    case YELLOW:
                        TotalResourcesWarehouse[2] += c;
                        break;
                    case GREY:
                        TotalResourcesWarehouse[3] += c;
                        break;
                }
            }
        }

        //controllo quanti elementi ha row3 con un for (al massimo ho tre elementi) e poi controllo il colore di tali elementi
        for (int c = 1; c < 4; c++) {
            if (row3.size() == c) {
                switch (Colorrow3) {
                    case PURPLE:
                        TotalResourcesWarehouse[0] += c;
                        break;
                    case BLUE:
                        TotalResourcesWarehouse[1] += c;
                        break;
                    case YELLOW:
                        TotalResourcesWarehouse[2] += c;
                        break;
                    case GREY:
                        TotalResourcesWarehouse[3] += c;
                        break;
                }
            }
        }

        //SOLO IN CASO AVESSI GIà UNA LEADERCARD CHE AGGIUNGE SPAZIO AL WAREHOUSE ATTIVATA
        // controllo quanti elementi ha rowextra1 con un for (al massimo ho due elementi) e poi controllo il colore di tali elementi
        for (int c = 1; c < 3; c++) {
            if (rowextra1.size() == c) {
                switch (ColorrowExtra1) {
                    case PURPLE:
                        TotalResourcesWarehouse[0] += c;
                        break;
                    case BLUE:
                        TotalResourcesWarehouse[1] += c;
                        break;
                    case YELLOW:
                        TotalResourcesWarehouse[2] += c;
                        break;
                    case GREY:
                        TotalResourcesWarehouse[3] += c;
                        break;
                }
            }
        }
//mi serve per la produzione in caso avessi due carte leader entrambe magazzino extra.
        for (int c = 1; c < 3; c++) {
            if (rowextra2.size() == c) {
                switch (ColorrowExtra1) {
                    case PURPLE:
                        TotalResourcesWarehouse[0] += c;
                        break;
                    case BLUE:
                        TotalResourcesWarehouse[1] += c;
                        break;
                    case YELLOW:
                        TotalResourcesWarehouse[2] += c;
                        break;
                    case GREY:
                        TotalResourcesWarehouse[3] += c;
                        break;
                }
            }
        }

        return TotalResourcesWarehouse;
    }
}




// funzione per gestire i row extra




