package domain;

public class DivideAndConquer {

    /**
     * Iteractive binary search
     * */
    public static int binarySearch(int sortedArray[], int value){
        int low = 0;
        int high = sortedArray.length-1; //ult pos del arreglo
        int middle = (low+high)/2; //mitad del arreglo
        while (low<=high && (sortedArray[middle]!=value)){
            if(value<sortedArray[middle])
                high = middle - 1;
            else
                low = middle + 1;
            middle = (low+high)/2; //mitad del arreglo
        }
        if(low>high) //no esta el elemento
            return -1; //elemento no existe
        return middle; //retorna la pos del elemento buscado
    }

    /**
     * Recrusive binary Search
     * */
    public static int binarySearch(int sortedArray[], int value, int low, int high){
        int middle = (low+high)/2;
        //Casos base
        if(low>high)
            return -1; //elemento no existe
        else if (value==sortedArray[middle])
            return middle; //pos del elemento buscado
        //Casos recursivos
        else if(value<sortedArray[middle])
            return binarySearch(sortedArray, value, low, middle-1);
        else
               return binarySearch(sortedArray, value, middle+1, high);
    }
}
