import java.util.Arrays;

public class SpiralFilling {
    public static void main(String[] args) {
        int[][] array = new int[10][9];
        printArray(fillArray(array));
    }

    public static int[][] invertArray(int[][] array){   //поворачиваем массив на 90 град влево
        int[][] iArray = new int[array[0].length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                iArray[array[i].length - j - 1][i] = array[i][j];
            }
        }
        return iArray;
    }

    public static int[][] fillArray(int[][] array){
        int max = array[0].length * array.length + 1;   //max + 1(из-за дополнительного тика счетчика вконце цикла)
        int incNumber = 1;                              //инкрементное число
        int fullTurnCounter = 0;
        int turnCounter = 0;
        do {
            int i = fullTurnCounter;
            do{                                         //цикл For не канает, нужно делать первую операцию всегда
                if (array[fullTurnCounter][i] == 0){    //решение специфичной ситуации для массивов типа [4][3]
                    array[fullTurnCounter][i] = incNumber;
                    incNumber++;
                }
                i++;
            } while (i < array[0].length - 1 - fullTurnCounter);

            array = invertArray(array);                 //переворачиваем
            turnCounter++;                              //счетчик переворотов
            if (turnCounter % 4 == 0) {
                fullTurnCounter++;                      //счетчик полных оборотов
            }
        } while (incNumber != max);

        while (turnCounter % 4 != 0){                   //переворот массива в исходное состояние
            array = invertArray(array);
            turnCounter++;
        }
        return array;
    }

    public static void printArray(int[][] array){
        for (int[] elm : array) {
            System.out.println(Arrays.toString(elm));
        }
    }
}
