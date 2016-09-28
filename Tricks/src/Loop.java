
public class Loop {
    public static void main(String[] args) {
        int[][] tab = {{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9}};
        boolean found = false;
        int searchValue = 5;
        searchLoop: for(int i=0; i<tab.length; i++) {
            for(int j=0; j<tab[i].length; j++) {
                if(tab[i][j] == searchValue) {
                    found = true;
                    break searchLoop;
                }
            }
        }
        
        if(found) {
            System.out.println("Odnaleziono " + searchValue);
        } else {
            System.out.println("Nie odnaleziono " + searchValue);
        }
    }
}
