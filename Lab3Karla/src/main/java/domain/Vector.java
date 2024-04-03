package domain;

public class Vector implements VectorList{
    private int n; //capacidad max del vector
    private int data[]; //almacenamiento interno
    private int counter; //cant elementos agregados

    public Vector(int n){
        this.n = n;
        this.counter = 0;
        this.data = new int[n];
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void clear() {
        this.counter = 0;
        this.data = new int[n];
    }

    @Override
    public boolean isEmpty() {
        return this.counter==0;
    }

    @Override
    public boolean contains(Object element) {
        bubbleSort(); //primero se debe ordenar el arreglo
        return DivideAndConquer.binarySearch(this.data,
                (int)element, 0, counter-1)!=-1;
    }

    @Override
    public void add(Object element) {
        if(this.counter<this.data.length)
            this.data[counter++] = (int)element;
    }

    @Override
    public void add(int index, Object element) {
        if(index<this.data.length){
            this.data[index] = (int)element;
            if(counter<=index)
                counter = index+1; //actualizo counter
        }
    }

    @Override
    public boolean remove(Object element) {
        if (!(element instanceof Integer)) // Verificar si el elemento pasado es de tipo Integer
            return false;

        int valueToRemove = (int) element;

        for (int i = 0; i < counter; i++) {
            if (data[i] == valueToRemove) {
                for (int j = i; j < counter - 1; j++) {
                    data[j] = data[j + 1];
                }
                data[counter - 1] = 0; // Reemplazar con 0 en lugar de null
                counter--;
                return true;
            }
        }
        return false;
    }








    @Override
    public Object remove(int index) {
        if (index >= 0 && index < counter) {
            Object removedValue = data[index]; // Almacenamos el valor a ser eliminado
            for (int i = index; i < counter - 1; i++) {
                data[i] = data[i + 1]; // Movemos los elementos una posición a la izquierda
            }
            data[counter - 1] = 0; // Asignamos null al último elemento (o un valor válido para indicar posición vacía)
            counter--; // Decrementamos el contador
            return removedValue; // Devolvemos el valor eliminado
        }
        return null; // Devolvemos null si el índice está fuera de rango
    }



    @Override
    public void sort() {
        this.bubbleSort(); //ordenamos por burbuja
    }

    @Override
    public int indexOf(Object element) {
       bubbleSort(); //ordenamos el vector
        return DivideAndConquer.binarySearch(this.data,
                (int)element, 0, counter-1);
    }

    @Override
    public Object get(int index) {
        if (index >= 0 && index < counter) {
            return data[index];
        }
        return null;
    }


    @Override
    public String toString() {
        String result="Vector Content...\n";
        int x=0;
        int i=0;
        for(int element: this.data){
            if(x++>=30){
                result+="\n";
                x=0; //init
            }
            //if(element==0) break; //rompe el bucle
            if(i++>=counter) break; //rompe el bucle
            result+=element+" ";
        }
        return result;
    }

    // An optimized version of Bubble Sort
    private void bubbleSort() {
        boolean swapped;
        int n = this.data.length;
        for (int i = 0; i < counter; i++) {
            swapped = false;
            for (int j = i+1; j<counter; j++) {
                if(this.data[j]<this.data[i]){
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    swapped = true;
                }
            }
            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
    public int[] getData() {
        return data;
    }

    public int getCounter() {
        return this.counter;
    }

    public int getLength() {
        return this.data.length;
    }
}
