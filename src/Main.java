public class Main {
    public static void main(String[] args) {

        String[][] seats = {
            {"Moiz", "Angie", "Taran", "Kelvin", "Kyler", "David", "WenHao Huang", "Nicole", "Jennifer", "Michelle",null,null},
            {"Beckett", "Raymond", "Lucy", "Apramjot", "Justin Lema", "Sam", "Tristan", "Pradeep", "Mohammad", "Haley", null, "Rely"},
            {"Cheng Han", "Qihan", "Kevin", "Ryan", "Justin Liu", "Jeffrey", "Danny", "Elliot", "Benson", "Fiona", "Neil", "Kaitlyn"}
        };

        String[][] copy = new String[3][12];


        String[][] fl = new String[3][12];
        int colLen = copy[0].length - 2;
        for (int r = 0; r < copy.length; r ++) {
            for (int c = 0; c < copy[0].length; c++) {
                if (seats[r][c] != null) {
//                else {
                    String stu = seats[r][c];

                    // randomize the names in the row from left to right
                    int randC = (int) (Math.random() * colLen);
                    while (copy[r][randC] != null) {
                        randC = (int) (Math.random() * colLen);
                    }
                    copy[r][randC] = stu;
                }

            }
            colLen ++;
        }

        for (int c = 0; c < copy[0].length; c ++) {
            int offset = 0;
            for (int r = 0; r < copy.length; r++) {
                if (copy[r][c] == null)
                      offset++;
                    String stu = copy[r][c];
//              randomize the column from up to down
                    int randR = (int) (Math.random() * (copy.length - offset)) + offset;
                    while (fl[randR][c] != null) {
                        randR = (int) (Math.random() * (copy.length - offset)) + offset;
                    }
                    fl[randR][c] = stu;
            }

        }
        // put null from second row to the last seat
        fl[1][fl[0].length - 1] = fl[fl.length - 1][fl[0].length-1];
        fl[fl.length - 1][fl[0].length - 1] = null;
        // remove this ^ emtpy seat in second row


        int seat = 1;
        for (String[] arr : fl) {
            for (String stu : arr) {
                if (stu != null) {

                    System.out.print("Comp " + seat + ": " + stu + " | ");
                    seat++;
                }
                else if (seat > 12) {
                    System.out.print("Comp " + seat + ": Empty | ");
                    seat++;
                }
            }
            System.out.println();
        }
    }

}

